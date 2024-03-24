import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        int[] answer = new int[sources.length];
        int[] dist = new int[n + 1];
        Arrays.fill(dist, -1);

        ArrayList<Integer>[] adjList = new ArrayList[n + 1];
        ArrayDeque<Integer> deque = new ArrayDeque<>();

        for (int i = 1; i < n + 1; i++) {
            adjList[i] = new ArrayList<>();
        }

        // 인접 리스트 왕복
        for (int[] arr : roads) {
            adjList[arr[0]].add(arr[1]);
            adjList[arr[1]].add(arr[0]);
        }

        dist[destination] = 0;
        deque.addLast(destination);

        while (!deque.isEmpty()) {
            int now = deque.pollFirst();

            for (int next : adjList[now]) { // 인접리스트 순회
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