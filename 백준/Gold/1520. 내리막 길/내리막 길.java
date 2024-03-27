import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {

    public static int [] rx = {-1, 1, 0 ,0};
    public static int [] ry = {0, 0, -1, 1};

    private static int[][] map;
    private static int[][] cnt;
    private static int N, M;

    public static class Node {
        int r,c;

        public Node(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        cnt = new int[N][M];

        // 입력 값 세팅
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                cnt[i][j] = -1;
            }
        }

        cnt[N-1][M-1] = 1;

        dfs(new Node(0,0));
        
        System.out.println(cnt[0][0]);
    }

    public static int dfs(Node now) {
        if (cnt[now.r][now.c] > -1) { // 무조건 방문한 정점은 0 이상이므로
            return cnt[now.r][now.c];
        }

        cnt[now.r][now.c] = 0;

        for (int i = 0; i < 4; i++) {
            int nr = now.r + ry[i];
            int nc = now.c + rx[i];

            if (nr < 0 || nc < 0 || nr >= N || nc >= M) // 맵 밖으로 빠져나가는 경우
                continue;

            if (map[now.r][now.c] > map[nr][nc]) { // 다음 이동한 곳이 현재 정점보다 낮은 경우만 이동 가능
                cnt[now.r][now.c] += dfs(new Node(nr, nc));
            }

        }
        return cnt[now.r][now.c];
    }

}