// 1. target, cost로 이루어진 Node 클래스를 만든다. (다익스트라)
// 2. pq와 dist, visited 배열을 만든다.
// 3. 인접 리스트를 만들고, 양쪽 다 가능하므로 양방향으로 만든다. a -> b로 cost c 이렇게
// 4. pq에 시작 지점을 넣고 다익스트라를 돌린다.
// 5. 모든 x에 대해 start -> x + x -> a + x -> b가 최소인 경우를 구하면 됨.
import java.util.*;

class Node {
    int target, cost;
    public Node (int target, int cost) {
        this.target = target;
        this.cost = cost;
    }
}
class Solution {
    private static List<Node>[] adjList;
    public int solution(int n, int s, int a, int b, int[][] fares) {
        adjList = new ArrayList[n+1];
        for (int i=1; i<=n; i++) adjList[i] = new ArrayList<>();
        
        for (int[] fare : fares) {
            adjList[fare[0]].add(new Node(fare[1], fare[2]));
            adjList[fare[1]].add(new Node(fare[0], fare[2]));
        }
        
        int[] pathS = dijkstra(s, n);
        int[] pathA = dijkstra(a, n);
        int[] pathB = dijkstra(b, n);
        
        int sum = Integer.MAX_VALUE;
        for (int i=1; i<=n; i++) {
            if (sum > pathS[i] + pathA[i] + pathB[i]) sum = pathS[i] + pathA[i] + pathB[i];
        }
        
        return sum;
    }
    private int[] dijkstra(int s, int n) {
        int[] dist = new int[n+1];
        boolean[] visited = new boolean[n+1];
        for (int i=0; i<=n; i++) dist[i] = Integer.MAX_VALUE;
        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.cost, o2.cost));
        dist[s] = 0;
        pq.add(new Node(s, 0));
        
        while(!pq.isEmpty()) {
            Node now = pq.poll();
            
            if (visited[now.target]) continue;
            
            visited[now.target] = true;
            
            for (Node next : adjList[now.target]) {
                if (dist[next.target] > now.cost + next.cost) {
                    dist[next.target] = now.cost + next.cost;
                    pq.add(new Node(next.target, dist[next.target]));
                }
            }
        }
        return dist;

    }
}