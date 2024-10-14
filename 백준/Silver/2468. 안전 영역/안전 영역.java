import java.io.*;
import java.util.*;

class Node {
    int r, c;

    public Node(int r, int c) {
        this.r = r;
        this.c = c;
    }
}

class Main {
    static int N;
    static boolean[][] visited;
    static int[][] map, dist;
    static int[] rx = {-1, 1, 0, 0};
    static int[] ry = {0, 0, -1, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        dist = new int[N][N];
        visited = new boolean[N][N];
        int max = 1, min = 100;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                max = Math.max(map[i][j], max);
                min = Math.min(map[i][j], min);
            }
        }

        int maxSafeZones = 1;

        for (int i = 1; i <= max; i++) {
            visited = new boolean[N][N];
            int res=0;
            for (int k = 0; k < N; k++) {
                for (int j = 0; j < N; j++) {
                    if (!visited[k][j] && map[k][j] > i) {
                        bfs(new Node(k,j), i);
                        res++;
                    }
                }
            }
            maxSafeZones = Math.max(maxSafeZones, res);
        }
            System.out.println(maxSafeZones);
    }
    public static void bfs(Node start, int rain) {
        ArrayDeque<Node> deque = new ArrayDeque<>();
        visited[start.r][start.c] = true;
        deque.addLast(start);

        while(!deque.isEmpty()) {
            Node now = deque.pollFirst();

            for (int i = 0; i < 4; i++) {
                int nr = now.r + rx[i];
                int nc = now.c + ry[i];

                if (nr < 0 || nc < 0 || nr >= N || nc >= N || map[nr][nc] <= rain) {
                    continue;
                }

                if (!visited[nr][nc] && map[nr][nc] > rain) {
                    visited[nr][nc] = true;
                    deque.addLast(new Node(nr, nc));
                }
            }
        }
    }

}


