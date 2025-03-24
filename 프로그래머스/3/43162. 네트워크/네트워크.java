import java.util.*;
class Solution {
    private static boolean[] visited;
    private static ArrayList<Integer>[] adjList;
    private static int res = 0;
    public int solution(int n, int[][] computers) {
        
        visited = new boolean[n];
        adjList = new ArrayList[n];
        for (int i=0; i<n; i++) adjList[i] = new ArrayList<>();
        
        for (int i=0; i<n; i++) {
            for (int k=0; k<n; k++) {
                if (computers[i][k] == 1 && i != k) adjList[i].add(k);
            }
        }
        
        for (int i=0; i<n; i++) {
            if(!visited[i]) {
                dfs(i);
                res++;
            }
            
        }
        return res;
    }
    private static void dfs(int now) {
        visited[now] = true;
        for (int next : adjList[now]) {
            if (!visited[next]) {
                dfs(next);
            }
        }
    
    }
}