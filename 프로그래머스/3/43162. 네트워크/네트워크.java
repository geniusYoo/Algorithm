class Solution {
    public static boolean [] visited;
    public static int [][] computer;
    public static int answer;
    public int solution(int n, int[][] computers) {
        answer = 0;
        computer = computers; // shallow copy
        visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(i);
                answer++;
            }

        }

        return answer;
    }

    public static void dfs(int now) {
        for (int i = 0; i < computer[now].length; i++) {
            if (computer[now][i] == 1 && !visited[i]) {
                visited[now] = true;
                dfs(i);
            }
        }
    }
}