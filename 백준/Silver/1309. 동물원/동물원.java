import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
    private static long [] dp;
    private static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        dp = new long [N+10];
        dp[1] = 3;
        dp[2] = 7;

        if (N <=2) {
            System.out.println(dp[N]);
            return;
        }

        for (int i = 3; i <= N; i++) {
            dp[i] = dp[i-2] + (dp[i-1]*2);
            dp[i] %= 9901;
        }
        System.out.println(dp[N] % 9901);
    }
}