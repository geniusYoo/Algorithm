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
                        if (bfs(new Node(i, j))) moved = true;
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
    public static boolean bfs(Node start) {
        ArrayDeque<Node> deque = new ArrayDeque<>();
        ArrayList<Node> union = new ArrayList<>();
        int cnt=0, sum=0;
        deque.addLast(start);
        visited[start.r][start.c] = true;

        while (!deque.isEmpty()) {
            Node now = deque.pollFirst();
            union.add(now);
            sum += map[now.r][now.c];
            cnt++;

            for (int i = 0; i < 4; i++) {
                int nr = now.r + rx[i];
                int nc = now.c + ry[i];

                if (nr < 0 || nc < 0 || nr >= N || nc >= N) continue;
                if (visited[nr][nc]) continue;

                int diff = Math.abs(map[now.r][now.c] - map[nr][nc]);

                if (diff >= L && diff <= R) {
                    visited[nr][nc] = true;
                    deque.addLast(new Node(nr, nc));
                }
            }
        }

        if (cnt == 1) return false;

        int avg = sum / cnt;
        for (Node node : union) {
            map[node.r][node.c] = avg;
        }
        return true;
    }
 }