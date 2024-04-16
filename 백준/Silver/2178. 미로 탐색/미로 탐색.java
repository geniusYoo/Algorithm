import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.StringTokenizer;

class Node {
    int x, y;

    public Node(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

class Main {
    public static int [] rx = {-1, 1, 0, 0};
    public static int [] ry = {0, 0, 1, -1};
    public static int [][] map;
    public static boolean [][] visited;
    public static ArrayDeque<Node> deque;
    public static int [][] dist;
    public static int N, M, cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        deque = new ArrayDeque<>();
        visited = new boolean [N][M];
        map = new int [N][M];
        dist = new int [N][M];
        cnt = 0;
        for (int i = 0; i < N; i++) {
            char [] arr = br.readLine().toCharArray();
            for (int j = 0; j < M; j++) {
                map[i][j] = arr[j] - '0';
            }
        }


        bfs();

    }

    public static void bfs() {
        deque.addLast(new Node(0,0));
        visited[0][0] = true;
        dist[0][0] = 1;
        while (!deque.isEmpty()) {
            Node now = deque.pollFirst();

            for (int i = 0; i < 4; i++) {
                int nr = now.x + rx[i];
                int nc = now.y + ry[i];

                // 맵 밖으로 벗어나는 경우
                if (nr < 0 || nc < 0 || nr >= N || nc >= M) continue;

                if (map[nr][nc] == 0) continue;

                if (!visited[nr][nc] && map[nr][nc] == 1) {
                    visited[nr][nc] = true;
                    deque.addLast(new Node(nr, nc));
                    dist[nr][nc] = dist[now.x][now.y] + 1;
                }

            }
        }
        System.out.println(dist[N-1][M-1]);
    }
}