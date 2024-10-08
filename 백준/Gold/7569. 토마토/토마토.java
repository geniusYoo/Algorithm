import java.io.*;
import java.util.*;

class Node {
    int h, c, r;

    public Node(int h, int c, int r) {
        this.h = h;
        this.c = c;
        this.r = r;
    }
}
class Main {
    static int[] rx = {-1,1,0,0,0,0};
    static int[] ry = {0,0,-1,1,0,0};
    static int[] rz = {0,0,0,0,-1,1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());
        int res = -1;
        int[][][] box = new int[H][N][M];
        boolean[][][] visited = new boolean[H][N][M];
        int[][][] dist = new int[H][N][M];
        ArrayDeque<Node> deque = new ArrayDeque<>();
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < M; k++) {
                    box[i][j][k] = Integer.parseInt(st.nextToken());
                    if (box[i][j][k] == 1) {
                        deque.addLast(new Node(i,j,k));
                        visited[i][j][k] = true;
                        dist[i][j][k] = 1;
                    }
                    if (box[i][j][k] == -1) {
                        dist[i][j][k] = -1;
                    }
                }
            }
        }
        int zero_cnt = 0;
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    if (box[i][j][k] == 0) zero_cnt++;
                }
            }
        }
        if (zero_cnt == 0) { // 익을 토마토가 없는 경우
            System.out.println(0);
            return;
        }
        
        while(!deque.isEmpty()) {
            Node now = deque.pollFirst();
            for (int i = 0; i < 6; i++) {
                int nh = now.h + rz[i];
                int nc = now.c + ry[i];
                int nr = now.r + rx[i];

                if (nr < 0 || nc < 0 || nh < 0 || nr >= M || nc >= N || nh >= H) continue;
                
                if (box[nh][nc][nr] == -1) continue;
                
                if (!visited[nh][nc][nr]) {
                    visited[nh][nc][nr] = true;
                    deque.addLast(new Node(nh, nc, nr));
                    dist[nh][nc][nr] = dist[now.h][now.c][now.r] + 1;
                    res = Math.max(dist[nh][nc][nr], res);
                }
            }
        }


        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    if (dist[i][j][k] == 0) {
                        System.out.println(-1);
                        return;
                    }
                }
            }
        }
        System.out.println(res-1);
    }



}


