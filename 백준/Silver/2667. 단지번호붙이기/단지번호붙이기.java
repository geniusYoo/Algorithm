import java.io.*;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;

class Node {
    int r,c;

    public Node(int r, int c) {
        this.r = r;
        this.c = c;
    }
}

class Main {
    static int N, res_cnt;
    static boolean[][] visited;
    static int[][] map;
    static ArrayDeque<Node> deque = new ArrayDeque<>();
    static ArrayList<Integer> res = new ArrayList<>();
    static int[] rx = {-1, 1, 0, 0};
    static int[] ry = {0, 0, -1, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        visited = new boolean[N][N];
        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            char[] arr = br.readLine().toCharArray();
            for (int j = 0; j < arr.length; j++) {
                map[i][j] = arr[j] - '0';
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 1 && !visited[i][j]) {
                    res_cnt++;
                    deque.add(new Node(i,j));
                    visited[i][j] = true;
                    res.add(bfs());
                }
            }
        }
        System.out.println(res_cnt);
        Collections.sort(res);
        for (int i : res) {
            System.out.println(i);
        }
//        System.out.println(Arrays.deepToString(visited));
    }
    public static int bfs() {
        int cnt = 1;
        while(!deque.isEmpty()) {
            Node now = deque.pollFirst();

            for (int i = 0; i < 4; i++) {
                int nr = now.r + rx[i];
                int nc = now.c + ry[i];

                if (nr < 0 || nc < 0 || nr >= N || nc >= N) continue;

                if (map[nr][nc] == 0) continue;

                if (!visited[nr][nc]) {
                    visited[nr][nc] = true;
                    deque.add(new Node(nr, nc));
                    cnt++;
                }
            }
        }
        return cnt;
    }

}


