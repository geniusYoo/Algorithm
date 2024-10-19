import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 접시 수
        int D = Integer.parseInt(st.nextToken()); // 초밥 가짓수
        int K = Integer.parseInt(st.nextToken()); // 연속 먹는 접시 수
        int C = Integer.parseInt(st.nextToken()); // 쿠폰 번호

        int[] sushi = new int[N];
        int[] cnt = new int[D + 1];
        int unique = 0;
        int max = 0;

        for (int i = 0; i < N; i++) {
            sushi[i] = Integer.parseInt(br.readLine());
        }

        for (int i = 0; i < K; i++) {
            if (cnt[sushi[i]] == 0) unique++;
            cnt[sushi[i]]++;
        }

        max = unique;

        for (int i = 0 ; i < N; i++) {
            cnt[sushi[i]]--;
            if (cnt[sushi[i]] == 0) unique--;

            int next = sushi[(K + i)%N];
            if (cnt[next] == 0) unique++;
            cnt[next]++;

            max = Math.max(max, cnt[C] == 0 ? unique + 1 : unique);
        }

        System.out.println(max);
    }
}