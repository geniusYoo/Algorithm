import java.util.*;

class Solution {
    public int solution(int n, int[][] edge) {
        int answer = 0;
        
        ArrayList<Integer>[] adjList = new ArrayList[n+1];
        for (int i=1; i<=n; i++) adjList[i] = new ArrayList<>();
        
        for (int[] e : edge) {
            adjList[e[0]].add(e[1]);
            adjList[e[1]].add(e[0]);
        }
        
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        boolean[] visited = new boolean[n+1];
        int[] dist = new int[n+1];
        deque.addLast(1);
        visited[1] = true;
        while(!deque.isEmpty()) {
            int now = deque.pollFirst();
            
            for (int next : adjList[now]) {
                if(!visited[next]) {
                    deque.addLast(next);
                    visited[next] = true;
                    dist[next] = dist[now] + 1;
                }
            }
        }
        Arrays.sort(dist);
        for (int i=0; i<=n; i++) {
            answer = Math.max(answer, dist[i]);
        }
        int cnt = 0;
        for (int i=0; i<=n; i++) {
            if (answer == dist[i]) cnt++;
        }
        return cnt;
    }
}