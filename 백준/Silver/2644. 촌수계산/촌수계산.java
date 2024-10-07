import java.io.*;
import java.util.StringTokenizer;

class Main {
    static int N, M, res, P, C;
    static boolean[] visited;
    static int[][] adj;
    static boolean flag = false;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        C = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());

        M = Integer.parseInt(br.readLine());
        adj = new int[N+1][N+1];
        visited = new boolean[N+1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int parent = Integer.parseInt(st.nextToken());
            int child = Integer.parseInt(st.nextToken());
            adj[parent][child] = adj[child][parent] = 1;
        }
        visited[P] = true;
        dfs(P);
        if (!flag) System.out.println(-1);
    }
    public static void dfs(int start) {
        if (start == C) {
            System.out.println(res);
            flag = true;
            return;
        }
        for (int i = 1; i <= N; i++) {
            if (!visited[i] && adj[start][i] == 1) {
                visited[i] = true;
                res++;
                dfs(i);
                res--;
            }
        }
    }

}


