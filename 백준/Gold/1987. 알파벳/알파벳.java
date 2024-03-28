import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    private static boolean [] used;
    private static char [][] map;
    public static int R, C, result;

    public static int [] rx = {0, 0, -1, 1};
    public static int [] ry = {-1, 1, 0 ,0};

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

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        
        map = new char[R + 1][C + 1];
        used = new boolean['Z' - 'A' + 1];

        for (int i = 0; i < R; i++) {
            map[i] = br.readLine().toCharArray();
        }
        result = 0;

        used[map[0][0] - 'A'] = true;

        backtrack(new Node(0,0), 1);
        System.out.println(result);
    }
    public static void backtrack(Node now, int cnt) {
        result = Math.max(result, cnt);

        for (int i = 0; i < 4; i++) {
            int nr = now.r + ry[i];
            int nc = now.c + rx[i];

            if (nr < 0 || nc < 0 || nr >= R || nc >= C) // 맵 밖으로 나가는 경우
                continue;

            if (used[map[nr][nc] - 'A']) // 이미 지나온 문자열일 경우
                continue;

            used[map[nr][nc] - 'A'] = true;
            backtrack(new Node(nr, nc), cnt + 1);
            used[map[nr][nc] - 'A'] = false;
        }
    }
}