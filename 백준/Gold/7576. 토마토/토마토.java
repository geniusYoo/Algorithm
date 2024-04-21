import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Node {
    int r,c,day;

    public Node(int r, int c, int day) {
        this.r = r;
        this.c = c;
        this.day = day;
    }
}
class Main {
    private static List<Node> start = new ArrayList<>();
    private static boolean [][] visitied;
    private static int [] rx = {-1, 1, 0, 0};
    private static int [] ry = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int [][] map = new int [N][M];
        int [][] dist = new int [N][M];
        visitied = new boolean[N][M];
        ArrayDeque<Node> deque = new ArrayDeque<>();

        // map setting
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1) {
                    deque.addLast(new Node(i,j,0));
                }
            }
        }

        while (!deque.isEmpty()) {
            Node now = deque.pollFirst();

            for (int i = 0; i < 4; i++) {
                int nr = now.r + rx[i];
                int nc = now.c + ry[i];

                if (nr < 0 || nc < 0 || nr >= N || nc >= M) // 맵을 벗어나면
                    continue;

                if (map[nr][nc] == -1)
                    continue;

                if (map[nr][nc] == 0) {
                    map[nr][nc] = 1;
                    map[nr][nc] = map[now.r]    [now.c]+1;
                    deque.addLast(new Node(nr, nc, now.day));
                }

            }
        }

        int max = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 0) {
                    System.out.println("-1");
                    return;
                }

                max = Math.max(max, map[i][j]);
            }
        }
        System.out.println(max - 1);
    }
}