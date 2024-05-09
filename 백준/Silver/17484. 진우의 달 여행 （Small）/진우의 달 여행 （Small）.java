import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.jar.Attributes;

class Node {
    int r,c;

    public Node(int r, int c) {
        this.r = r;
        this.c = c;
    }
}


class Main {
    private static int [] rx = {1, 1, 1};
    private static int [] ry = {-1, 0, 1};
    private static int [][] dp, map;
    private static int N,M;
    private static int res = 100_000;
    public enum Operation {
        LEFT(0),
        DOWN(1),
        RIGHT(2);

        Operation(int num) {

        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        dp = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (i == 0) {
                    dp[0][j] = map[i][j];
                }
            }
        }

        for (int i = 0; i < M; i++) {
            backtrack(-1, new Node(0,i), 0);
        }

        System.out.println(res);
    }

    public static void backtrack (int prev, Node now, int cnt) {
        if (cnt == N-1) {
            res = Math.min(res, dp[now.r][now.c]);
//            System.out.println(res);
            return;
        }
        for (int i = 0; i < 3; i++) {
            int nr = now.r + rx[i];
            int nc = now.c + ry[i];

            if (nr < 0 || nc < 0 || nr >= N || nc >= M) continue;

            if (prev == i) continue;

            dp[nr][nc] = dp[now.r][now.c] + map[nr][nc];

            backtrack(i, new Node(nr, nc), cnt+1);
        }
    }

}