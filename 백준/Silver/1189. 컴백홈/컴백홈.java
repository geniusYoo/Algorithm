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
    private static int [][] dist;
    private static String [][] map;
    private static boolean [][] visited;
    private static ArrayDeque<Node> deque;
    private static int res;
    private static int [] nx = {-1, 1, 0, 0};
    private static int [] ny = {0, 0, -1, 1};
    private static int R, C, K;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        dist = new int [R][C];
        map = new String [R][C];
        visited = new boolean[R][C];
        deque = new ArrayDeque<>();

        for (int i = 0; i < R; i++) {
            String s = br.readLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = String.valueOf(s.charAt(j));
            }
        }
        visited[R-1][0] = true;

        dfs(new Node(R-1, 0), 1);

        System.out.println(res);
    }

    public static void dfs(Node now, int cnt) {
        if (now.r == 0 && now.c == C-1) {
            if (cnt == K) res++;
            
        }
        else {
            for (int i = 0; i < 4; i++) {
                int nr = now.r + nx[i];
                int nc = now.c + ny[i];

                if (nr < 0 || nc < 0 || nr >= R || nc >= C) continue;

                if (map[nr][nc].equals("T")) continue;

                if (!visited[nr][nc] && map[nr][nc].equals(".")) {
                    visited[nr][nc] = true;
                    dfs(new Node(nr, nc), cnt + 1);
                    visited[nr][nc] = false;
                }
            }
        }

    }




}