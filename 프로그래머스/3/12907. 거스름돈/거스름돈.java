class Solution {
    public int solution(int n, int[] money) {
        int [][] dp = new int [money.length + 1][n + 1];

        for (int i = 0; i <= money.length; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i <= money.length; i++) {
            for (int j = 1; j <= n; j++) {
                int now = money[i-1]; // 현재 돈
                dp[i][j] = dp[i-1][j]; // 직전 값 복사
                if (j < now) continue;
                dp[i][j] += dp[i][j - now];
                dp[i][j] %= 1_000_000_007;
            }
        }
        return dp[money.length][n];
    }
}