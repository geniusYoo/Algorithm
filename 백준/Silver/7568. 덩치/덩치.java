import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int [][] size = new int[N][3];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            size[i][0] = Integer.parseInt(st.nextToken()); // 몸무게
            size[i][1] = Integer.parseInt(st.nextToken()); // 키
        }

        for (int i = 0; i < N; i++) {
            int score = 1;
            for (int j = 0; j < N; j++) {
                if (i == j) continue;
                // 나보다 덩치가 큰 사람
                if (size[i][0] < size[j][0] &&
                size[i][1] < size[j][1]) {
                    score++;
                }
            }
            size[i][2] = score;
        }
        for (int i = 0; i < N; i++) {
            System.out.print(size[i][2] + " ");
        }



    }
}