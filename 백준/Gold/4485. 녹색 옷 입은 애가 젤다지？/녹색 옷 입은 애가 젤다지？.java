import org.w3c.dom.Node;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    private static class Node {
        int r,c; // 좌표
        int cost;

        public Node(int r, int c, int cost) {
            this.r = r;
            this.c = c;
            this.cost = cost;
        }
    }
    private static int[][] map;
    private static int[][] dist;
    private static int[] rx = {-1, 1, 0, 0};
    private static int[] ry = {0, 0, -1, 1};
    private static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int idx = 0;
        while (true) {
            N = Integer.parseInt(br.readLine());
            if (N == 0) break;
            idx++;
            sb.append("Problem ").append(idx).append(": ");

            map = new int[N][N];
            dist = new int[N][N];

            for (int i = 0; i < N; i++) {
                Arrays.fill(dist[i], 1250);
            }
            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            dijkstra(new Node(0, 0, map[0][0]));
            sb.append(dist[N - 1][N - 1]).append("\n");
        }
        System.out.println(sb);
    }

    private static void dijkstra(Node start) {
        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.cost, o2.cost));

        dist[start.r][start.c] = map[start.r][start.c];
        pq.add(new Node(start.r, start.c, start.cost));

        while (!pq.isEmpty()) {
            Node now = pq.poll();

            if (now.cost > dist[now.r][now.c]) continue;

            for (int i = 0; i < 4; i++) {
                int nr = now.r + rx[i];
                int nc = now.c + ry[i];

                if (nr < 0 || nc < 0 || nr >= N || nc >= N) continue;

                if (dist[nr][nc] > now.cost + map[nr][nc]) {
                    dist[nr][nc] = now.cost + map[nr][nc];
                    pq.add(new Node(nr, nc, now.cost + map[nr][nc]));
                }
            }
        }


    }
}