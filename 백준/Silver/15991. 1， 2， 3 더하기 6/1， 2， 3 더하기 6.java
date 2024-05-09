import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
    private static long [] dp;
    private static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        dp = new long[100_001];

        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 2;
        dp[4] = 3;
        dp[5] = 3;
        dp[6] = 6;

        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());
            if (dp[num] > 0) {
                System.out.println(dp[num]);
                continue;
            }

            for (int j = 7; j <= num; j++) {
                dp[j] = (dp[j-2] + dp[j-4] + dp[j-6]) % 1_000_000_009;
            }

            System.out.println(dp[num]);

        }
    }

}