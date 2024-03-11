import java.util.ArrayDeque;

class Solution {
    public static int [] rx = {0, 0, 1, -1};
    public static int [] ry = {1, -1, 0, 0};

    private static class Node {
        int r, c;

        public Node(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    public int solution(int[][] maps) {
        int N = maps.length;
        int M = maps[0].length;

        ArrayDeque<Node> queue = new ArrayDeque<>();
        boolean [][] visited = new boolean[N][M];
        int [][] dist = new int [N][M];

        queue.addLast(new Node(0,0));
        visited[0][0] = true;
        dist[0][0] = 1;

        while(!queue.isEmpty()) {
            Node now = queue.pollFirst(); // 현재 위치의 정점을 꺼낸다

            for (int i = 0; i < 4; i++) { // 상하좌우로 이동
                int nr = now.r + rx[i];
                int nc = now.c + ry[i];

                if (nr < 0 || nc < 0 || nr >= N || nc >= M) // 맵 밖으로 벗어날 때
                    continue;

                if (maps[nr][nc] == 0) // 벽일 때
                    continue;

                if (!visited[nr][nc]) { // 방문하지 않은 정점이라면, 큐에 넣고 방문 체크 후 최단거리 계산
                    visited[nr][nc] = true;
                    queue.addLast(new Node(nr, nc));
                    dist[nr][nc] = dist[now.r][now.c] + 1;
                }
            }
        }

        return dist[N-1][M-1] == 0 ? -1 : dist[N-1][M-1];
    }
}