import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Node {
    int r, c;
    public Node(int r, int c) {
        this.r = r;
        this.c = c;
    }
}

public class Main {
    static int[] rx = {-1, 1, 0, 0};
    static int[] ry = {0, 0, -1, 1};
    static int N, L, R, res;
    static int[][] map;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        map = new int[N][N];

        // map 세팅
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        while (true) {
            visited = new boolean[N][N];
            boolean moved = false;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (!visited[i][j]) {
                        if (bfs(i, j)) {
                            moved = true;
                        }
                    }
                }
            }

            if (!moved) {
                System.out.println(res);
                return;
            }
            res++;
        }
    }

    public static boolean bfs(int startR, int startC) {
        Queue<Node> queue = new LinkedList<>();
        List<Node> union = new ArrayList<>();
        queue.add(new Node(startR, startC));
        visited[startR][startC] = true;
        int sum = 0, count = 0;

        while (!queue.isEmpty()) {
            Node now = queue.poll();
            union.add(now);
            sum += map[now.r][now.c];
            count++;

            for (int i = 0; i < 4; i++) {
                int nr = now.r + rx[i];
                int nc = now.c + ry[i];

                if (nr < 0 || nc < 0 || nr >= N || nc >= N) continue;
                if (visited[nr][nc]) continue;

                int diff = Math.abs(map[now.r][now.c] - map[nr][nc]);

                if (diff >= L && diff <= R) {
                    visited[nr][nc] = true;
                    queue.add(new Node(nr, nc));
                }
            }
        }

        if (count == 1) return false; // 연합이 하나뿐이면 이동 없음

        int avg = sum / count;
        for (Node node : union) {
            map[node.r][node.c] = avg;
        }

        return true; // 이동 발생
    }
}
