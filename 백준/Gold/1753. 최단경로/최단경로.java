import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    private static class Node {
        int target, weight;

        public Node(int target, int weight) {
            this.target = target;
            this.weight = weight;
        }
    }
    private static ArrayList<Node>[] adjList;
    private static boolean[] visited;
    private static int[] dist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(br.readLine());

        adjList = new ArrayList[V + 1];
        visited = new boolean[V + 1];
        dist = new int[V + 1];

        for (int i = 0; i <= V; i++) {
            adjList[i] = new ArrayList<>();
        }
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            adjList[u].add(new Node(v, w));
        }

        dijkstra(start);

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= V; i++) {
            if (dist[i] == Integer.MAX_VALUE) sb.append("INF\n");
            else sb.append(dist[i] + "\n");
        }
        System.out.println(sb);
    }
    private static void dijkstra(int start) {
        Arrays.fill(dist, Integer.MAX_VALUE);

        PriorityQueue<Node> pq = new PriorityQueue<>(((o1, o2) -> Integer.compare(o1.weight, o2.weight)));
        dist[start] = 0;
        pq.add(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node now = pq.poll(); // 현재 정점

            if (visited[now.target]) continue; // 방문한 정점이면 건너뛰기

            visited[now.target] = true; // 방문 체크

            for (Node next : adjList[now.target]) { // 이동할 수 있는 정점들을 인접 리스트에서 꺼내기
                if (dist[next.target] > now.weight + next.weight) {
                    dist[next.target] = now.weight + next.weight;
                    pq.add(new Node(next.target, dist[next.target]));
                }
            }

        }
    }
}