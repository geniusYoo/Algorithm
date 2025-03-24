import java.util.*;
class Node {
    int r;
    int c;
    
    public Node(int r, int c) {
        this.r = r;
        this.c = c;
    }
}
class Solution {
    
    public int solution(int[][] maps) {
        boolean[][] visited = new boolean[maps.length][maps[0].length];
        int[][] dist = new int[maps.length][maps[0].length];
        int[] nx = {-1, 1, 0, 0};
        int[] ny = {0, 0, -1, 1};
        
        visited[0][0] = true;
        dist[0][0] = 1;
        
        ArrayDeque<Node> deque = new ArrayDeque<>();
        deque.addLast(new Node(0,0));
        while (!deque.isEmpty()) {
            Node now = deque.pollFirst();
            
            for (int i=0; i<4; i++) {
                int nr = now.r + nx[i];
                int nc = now.c + ny[i];
                
                if (nr >= maps.length || nc >= maps[0].length || nr < 0 || nc < 0) continue;
                if (maps[nr][nc] == 0) continue;
                
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