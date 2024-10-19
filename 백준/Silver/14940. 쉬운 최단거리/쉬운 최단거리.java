import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.StringTokenizer;

class Node {
    int r, c;
    public Node(int r, int c) {
        this.r = r;
        this.c = c;
    }
}
class Main {
    static int[] rx = {-1, 1, 0, 0};
    static int[] ry = {0, 0, -1, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] map = new int[N][M];
        boolean[][] visited = new boolean[N][M];
        int[][] dist = new int[N][M];
        ArrayDeque<Node> deque = new ArrayDeque<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 2) {
                    deque.addLast(new Node(i, j));
                    visited[i][j] = true;
                    map[i][j] = 0;
                }
            }
        }

        while(!deque.isEmpty()) {
            Node now = deque.pollFirst();

            for (int i = 0; i < 4; i++) {
                int nr = now.r + rx[i];
                int nc = now.c + ry[i];

                if (nr < 0 || nc < 0 || nr >= N || nc >= M) continue;

                if (map[nr][nc] == 0) continue;

                if (!visited[nr][nc] && map[nr][nc] == 1) {
                    visited[nr][nc] = true;
                    deque.addLast(new Node(nr, nc));
                    map[nr][nc] = map[now.r][now.c] + 1;
                }
            }
        }




        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (!visited[i][j] && map[i][j] == 1) map[i][j] = -1;
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }



    }
}