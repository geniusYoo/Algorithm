import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    public static void main(String[] args) {
        int[] res = solution(3, new int[][]{{1,2},{2,3}}, new int[]{2,3},1);
        for (Integer idx : res) {
            System.out.println("idx = " + idx);
        }
    }
    public static int[] solution(int n, int[][] roads, int[] sources, int destination) {
        int[] answer = new int[sources.length];
        int[] dist = new int[n+1];
        Arrays.fill(dist, -1);

        ArrayList<Integer>[] adjList = new ArrayList [n+1];
        ArrayDeque<Integer> deque = new ArrayDeque<>();

        for (int i = 0; i <= n; i++) {
            adjList[i] = new ArrayList<>();
        }

        for (int i = 0; i < roads.length; i++) {
            adjList[roads[i][0]].add(roads[i][1]);
            adjList[roads[i][1]].add(roads[i][0]);
        }

        dist[destination] = 0;
        deque.addLast(destination);

        while (!deque.isEmpty()) {
            int now = deque.pollFirst();

            for (int next : adjList[now]) {
                if (dist[next] == -1) {
                    dist[next] = dist[now] + 1;
                    deque.addLast(next);
                }
            }
        }

        for (int i = 0; i < sources.length; i++) {
            answer[i] = dist[sources[i]];
        }
        return answer;
    }
}