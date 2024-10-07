import java.io.*;
import java.util.*;

class Node {
    int r,c;

    public Node(int r, int c) {
        this.r = r;
        this.c = c;
    }
}
class Main {
    public static int[] rx = {-1, 1, 0, 0};
    public static int[] ry = {0, 0, -1, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] map = new int[N][M];
        int[][] dist = new int[N][M];
        boolean[][] visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            char[] arr = br.readLine().toCharArray();
            for (int j = 0; j < arr.length; j++) {
                map[i][j] = arr[j] - '0';
            }
        }

        ArrayDeque<Node> deque = new ArrayDeque<>();
        deque.addLast(new Node(0,0));
        visited[0][0] = true;
        dist[0][0] = 1;

        while (!deque.isEmpty()) {
            Node now = deque.pollFirst();

            for (int i = 0; i < 4; i++) {
                int nr = now.r + rx[i];
                int nc = now.c + ry[i];

                if (nr < 0 || nc < 0 || nr >= N || nc >= M ) continue;

                if (map[nr][nc] == 0) continue;

                if (!visited[nr][nc]) {
                    visited[nr][nc] = true;
                    deque.addLast(new Node(nr,nc));
                    dist[nr][nc] = dist[now.r][now.c] + 1;
                }
            }
        }
        System.out.println(dist[N -1][M -1]);
    }
}


