import java.util.*;

class Solution {
    private static ArrayList<Integer>[] score;
    private static int[][] board;
    private static boolean[] visited;
    private static int N;
    public int solution(int n, int[][] results) {
        score = new ArrayList[n+1];
        board = new int[n+1][n+1];
        visited = new boolean[n+1];
        N = n;
        for (int i=1; i<=n; i++) score[i] = new ArrayList<>();
        for (int[] result : results) {
            score[result[0]].add(result[1]);
        }
        for (int i=1; i<=n; i++) {
            board[i][i] = -2;
            Arrays.fill(visited, false);
            dfs(i, i);
        }
        int[] rank = new int[n+1];
        int ans = 0;
        for (int i=1; i<=n; i++) {
            rank[i] = ranking(board[i]);
            if (rank[i] != -1) ans++;
        }
        return ans;
    }
    private static void dfs(int start, int now) {
        visited[now] = true;
        for (int next : score[now]) {
            if (!visited[next]) {
                board[start][next] = 1;
                board[next][start] = -1;
                dfs(start, next);
            }
        }
    }
    
    private static int ranking(int[] board) {
        int score = 0;
        for (int i=1; i<=N; i++) {
            if (board[i] == 0) return -1;
            else if (board[i] == -1) score++;
        }
        return score + 1;
    }
}