import java.util.ArrayDeque;
class Node {
    int r,c;

    public Node(int r, int c) {
        this.r = r;
        this.c = c;
    }
}

class Solution {
    public static int[] rx = {0, 0, 1, -1};
    public static int[] ry = {1, -1, 0, 0};
    public int solution(int[][] maps) {
        int answer = 0;

        boolean[][] visited = new boolean[maps.length][maps[0].length];
        int[][] dist = new int[maps.length][maps[0].length];
        
        ArrayDeque<Node> deque = new ArrayDeque<>();
        deque.addLast(new Node(0, 0));
        visited[0][0] = true;
        dist[0][0] = 1;

        while (!deque.isEmpty()) {
            Node now = deque.pollFirst();

            for (int i = 0; i < 4; i++) {
                int nr = now.r + rx[i];
                int nc = now.c + ry[i];

                if (nr < 0 || nc < 0 || nr >= maps.length || nc >= maps[0].length)
                    continue;
                if (maps[nr][nc] == 0)
                    continue;
                
                if (!visited[nr][nc]) {
                    visited[nr][nc] = true;
                    deque.addLast(new Node(nr, nc));
                    dist[nr][nc] = dist[now.r][now.c] + 1;
                }
            }
        }


        return dist[maps.length-1][maps[0].length-1] == 0 ? -1 : dist[maps.length-1][maps[0].length-1];
    }
}