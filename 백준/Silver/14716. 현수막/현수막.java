import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Node {
    int r,c;

    public Node(int r, int c) {
        this.r = r;
        this.c = c;
    }
}

class Main {
    private static int [][] map;
    private static boolean [][] visited;
    private static int [][] depth;
    private static ArrayDeque<Node> deque;
    private static int [] nx = {-1, 1, 0, 0, -1, 1, 1, -1};
    private static int [] ny = {0, 0, -1, 1, 1, -1, 1, -1};
    private static List<Node> nodes = new ArrayList<>();


    private static int M, N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        map = new int[M][N];
        depth = new int[M][N];
        visited = new boolean[M][N];
        deque = new ArrayDeque<>();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1) nodes.add(new Node(i,j));
            }
        }
        int cnt = 0;

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 1 && !visited[i][j]) {
                    dfs(new Node(i,j));
                    cnt++;
                }
            }
        }
        System.out.println(cnt);
    }

    public static void dfs(Node now) {
        for (int i = 0; i < 8; i++) {
            int nr = now.r + nx[i];
            int nc = now.c + ny[i];

            if (nr < 0 || nc < 0 || nr >= M || nc >= N) continue;

            if (map[nr][nc] == 0) continue;

            if (!visited[nr][nc]) {
                visited[nr][nc] = true;
                dfs(new Node(nr, nc));
            }
        }
    }



}