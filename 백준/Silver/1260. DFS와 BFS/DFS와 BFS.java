import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    private static boolean [] visited;
    private static List<Integer>[] adjList;
    private static ArrayDeque<Integer> deque;
    private static StringBuilder sb;
    private static StringBuilder sb2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());

        sb = new StringBuilder();
        sb2 = new StringBuilder();

        visited = new boolean[N + 1];

        // 인접 리스트 생성
        adjList = new ArrayList[N + 1];
        deque = new ArrayDeque<>();

        for (int i = 1; i < N + 1; i++) {
            adjList[i] = new ArrayList<>();
        }

        // 인접 리스트 세팅
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int idx = Integer.parseInt(st.nextToken());
            int val = Integer.parseInt(st.nextToken());
            adjList[idx].add(val);
            adjList[val].add(idx);
        }

        for (int i = 1; i < N + 1; i++) {
            Collections.sort(adjList[i]);
        }

        dfs(V);
        System.out.println(sb.toString().trim());

        Arrays.fill(visited, false);
        deque.addLast(V);
        bfs();
        System.out.print(sb2.toString().trim());
    }

    public static void dfs(int now) {
        if (visited[now]) return;
        visited[now] = true;
        sb.append(now);
        sb.append(" ");

        for (int i = 0; i < adjList[now].size(); i++) {
            if (adjList[now].get(i) != null) {
                dfs(adjList[now].get(i));
            }
        }
    }

    public static void bfs() {
        while (!deque.isEmpty()) {
            int now = deque.pollFirst();
            if (visited[now]) continue;
            visited[now] = true;
            sb2.append(now);
            sb2.append(" ");
            for (int i = 0; i < adjList[now].size(); i++) {
                if (!visited[adjList[now].get(i)]) {
                    deque.addLast(adjList[now].get(i));
                }
            }
        }
    }
}