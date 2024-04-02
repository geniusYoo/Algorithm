import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Goods {
    int weight, value;

    public Goods(int weight, int value) {
        this.weight = weight;
        this.value = value;
    }
}

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 물품의 수
        int K = Integer.parseInt(st.nextToken()); // 버틸 수 있는 무게
        
        Goods [] goods = new Goods[N + 1];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            goods[i] = new Goods(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        int [][] dp = new int [N + 1][K + 1];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= K; j++) {
                Goods now = goods[i];
                dp[i][j] = dp[i-1][j]; // 직전 값 복사
                if (j >= now.weight)
                    dp[i][j] = Math.max(dp[i][j], dp[i-1][j - now.weight] + now.value);
            }
        }

        System.out.println(dp[N][K]);
    }
}