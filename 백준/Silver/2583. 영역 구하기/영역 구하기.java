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

class Main {
    private static int [][] map;
    private static boolean [][] visited;
    private static int [][] width;
    private static ArrayDeque<Node> deque;
    private static int M, N;
    private static int [] rx = {-1, 1, 0, 0};
    private static int [] ry = {0, 0, -1, 1};
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        map = new int [M][N];
        visited = new boolean[M][N];
        width = new int [M][N];
        deque = new ArrayDeque<>();
        List<Integer> res = new ArrayList<>();
        for (int [] arr : map) {
            Arrays.fill(arr, 0);
        }

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            int nx = Integer.parseInt(st.nextToken());
            int ny = Integer.parseInt(st.nextToken());

            for (int j = x; j < nx ; j++) {
                for (int k = y; k < ny; k++) {
                    map[k][j] = 1;
                    visited[k][j] = true;
                }
            }
        }


        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) {
                    width[i][j] = bfs(new Node(i,j));
                    if (width[i][j] != 0) res.add(width[i][j]);
                }
            }
        }

        Collections.sort(res);
        System.out.println(res.size());
        for (Integer i : res) {
            System.out.print(i + " ");
        }

    }
    
    public static int bfs(Node start) {
        int cnt = 1;
        deque.addLast(start);
        visited[start.r][start.c] = true;
        while (!deque.isEmpty()) {
            Node now = deque.pollFirst();

            for (int i = 0; i < 4; i++) {
                int nr = now.r + rx[i];
                int nc = now.c + ry[i];
                
                if (nr < 0 || nc < 0 || nr >= M || nc >= N) continue;
                
                if (map[nr][nc] == 1) continue;
                
                if (!visited[nr][nc])
                {
                    deque.addLast(new Node(nr, nc));
                    visited[nr][nc] = true;
                    cnt++;
                }
                
            }

        }
        return cnt;
    }
}