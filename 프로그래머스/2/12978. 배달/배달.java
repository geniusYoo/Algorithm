import java.util.*;
class Node {
    int num;
    int cost;
    public Node(int num, int cost) {
        this.num = num;
        this.cost = cost;
    }
}
class Solution {
    public int solution(int N, int[][] road, int K) {
        ArrayList<Node>[] adjList = new ArrayList[N+1];
        boolean[] visited = new boolean[N+1];
        int[] dist = new int[N+1];
        
        Arrays.fill(dist, Integer.MAX_VALUE);
        
        for (int i=0; i<=N; i++) {
            adjList[i] = new ArrayList<>();
        }
        for (int[] r : road) {
            adjList[r[0]].add(new Node(r[1],r[2]));
            adjList[r[1]].add(new Node(r[0],r[2]));
        }
        
        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.cost, o2.cost));
        pq.add(new Node(1, 0));
        dist[1] = 0;
        while(!pq.isEmpty()) {
            Node now = pq.poll();
            
            if(visited[now.num]) continue;
            
            visited[now.num] = true;
            
            for(Node next : adjList[now.num]) {
                if(dist[next.num] > now.cost + next.cost) {
                    dist[next.num] = now.cost + next.cost;
                    pq.add(new Node(next.num, dist[next.num]));
                }
            }
        }
        int res = 0;
        for (int i=1; i<=N; i++) {
            if (dist[i] <= K) res++;
        }
        return res;
    }
}