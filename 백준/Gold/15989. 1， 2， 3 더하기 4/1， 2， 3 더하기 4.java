import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        int[][] dp = new int[10001][4];

        // 초기 조건 설정
        dp[1][1] = 1; // 1
        dp[2][1] = 1; // 1+1
        dp[2][2] = 1; // 2
        dp[3][1] = 1; // 1+1+1
        dp[3][2] = 1; // 1+2
        dp[3][3] = 1; // 3

        // DP 배열 채우기
        for (int i = 4; i <= 10000; i++) {
            dp[i][1] = dp[i - 1][1];  // i를 1로 끝내는 경우
            dp[i][2] = dp[i - 2][1] + dp[i - 2][2];  // i를 2로 끝내는 경우
            dp[i][3] = dp[i - 3][1] + dp[i - 3][2] + dp[i - 3][3];  // i를 3으로 끝내는 경우
        }

        // 테스트 케이스 처리
        for (int t = 0; t < T; t++) {
            int n = Integer.parseInt(br.readLine());
            sb.append(dp[n][1] + dp[n][2] + dp[n][3]).append("\n");
        }

        System.out.print(sb);
    }
}
