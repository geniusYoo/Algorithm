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
    public int solution(String[] maps) {
        int N = maps.length;
        int M = maps[0].length();
        ArrayDeque<Node> deque = new ArrayDeque<>();
        boolean[][] visited = new boolean[maps.length][maps[0].length()];
        int[][] dist = new int[N][M];
        int[] rx = {-1, 1, 0, 0};
        int[] ry = {0, 0, -1, 1};

        int startX = 0;
        int startY = 0;
        int leverX = 0;
        int leverY = 0;
        int endX = 0;
        int endY = 0;
        for (int i=0; i<maps.length; i++) {
            for (int k=0; k<maps[i].length(); k++) {
                if (maps[i].charAt(k) == 'S') {
                    startX = i;
                    startY = k;
                }
                if (maps[i].charAt(k) == 'L') {
                    leverX = i;
                    leverY = k;
                }
                if (maps[i].charAt(k) == 'E') {
                    endX = i;
                    endY = k;
                }
                
            }
        }
        int res = 0;
        deque.addLast(new Node(startX, startY));
        dist[startX][startY] = 0;
        visited[startX][startY] = true;
        while(!deque.isEmpty()) {
            Node now = deque.pollFirst();
            
            for (int i=0; i<4; i++) {
                int nr = now.r + rx[i];
                int nc = now.c + ry[i];
                
                if (nr >= N || nc >= M || nr < 0 || nc < 0) continue;
                if (maps[nr].charAt(nc) == 'X') continue;
                
                if(!visited[nr][nc]) {
                    visited[nr][nc] = true;
                    deque.addLast(new Node(nr, nc));
                    dist[nr][nc] = dist[now.r][now.c] + 1;
                }
            }
        }
        
        res += dist[leverX][leverY];
        if (res == 0) return -1;
        
        for (int i=0; i<N; i++) {
            Arrays.fill(dist[i], 0);
            Arrays.fill(visited[i], false);
        }
        deque.addLast(new Node(leverX, leverY));
        dist[leverX][leverY] = 0;
        visited[leverX][leverY] = true;
        while(!deque.isEmpty()) {
            Node now = deque.pollFirst();
            
            for (int i=0; i<4; i++) {
                int nr = now.r + rx[i];
                int nc = now.c + ry[i];
                
                if (nr >= N || nc >= M || nr < 0 || nc < 0) continue;
                if (maps[nr].charAt(nc) == 'X') continue;
                
                if(!visited[nr][nc]) {
                    visited[nr][nc] = true;
                    deque.addLast(new Node(nr, nc));
                    dist[nr][nc] = dist[now.r][now.c] + 1;
                }
            }
        }
        if (dist[endX][endY] == 0) return -1;
        res += dist[endX][endY];
        
        return res == 0 ? -1 : res;
    }
}