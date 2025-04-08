import java.util.*;
class Node {
    int r;
    int c;
    int dir;
    int cost;
    public Node (int r, int c, int dir, int cost) {
        this.r = r;
        this.c = c;
        this.dir = dir;
        this.cost = cost;
    }
}

class Solution {
    public int solution(int[][] board) {
        int[] rx = {-1, 1, 0, 0};
        int[] ry = {0, 0, -1, 1};
        int N = board.length;
        int[][][] visited = new int[N][N][4];
        ArrayDeque<Node> deque = new ArrayDeque<>();
        deque.addLast(new Node(0, 0, -1, 0));
        int answer = Integer.MAX_VALUE;
        while (!deque.isEmpty()) {
            Node now = deque.pollFirst();
            
            for (int i=0; i<4; i++) {
                int nr = now.r + rx[i];
                int nc = now.c + ry[i];
                
                if (nr < 0 || nc < 0 || nr >= N || nc >= N) continue;
                if (board[nr][nc] == 1) continue;
                
                int ncost = now.cost;
                if (now.dir == i || now.dir == -1) ncost += 100;
                else ncost += 600;
                
                if (nr == N-1 && nc == N-1) {
                    answer = Math.min(answer, ncost);
                }
                
                else if (visited[nr][nc][i] == 0 || visited[nr][nc][i] > ncost) {
                    deque.addLast(new Node(nr, nc, i, ncost));
                    visited[nr][nc][i] = ncost;
                }
            }
        }
        return answer;
    }
}