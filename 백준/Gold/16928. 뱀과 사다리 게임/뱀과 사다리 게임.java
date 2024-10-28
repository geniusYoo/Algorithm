import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        HashMap<Integer, Integer> mv = new HashMap<>();
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        for (int i = 0; i < N + M; i++) {
            st = new StringTokenizer(br.readLine());
            mv.put(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
        }

        ArrayDeque<Integer> deque = new ArrayDeque<>();
        int[] dist = new int[101];
        boolean[] visited = new boolean[101];
        deque.addLast(1);
        dist[1] = 0;
        visited[1] = true;

        while(!deque.isEmpty()) {
            int now = deque.pollFirst();
            if (now == 100) {
                System.out.println(dist[100]);
                return;
            }

            for (int i = 1; i < 7; i++) {
                int next = now + i;
                if (next > 100) continue;
                if (mv.containsKey(next)) {
                    next = mv.get(next);
                }
                if (!visited[next]) {
                    visited[next] = true;
                    deque.addLast(next);
                    dist[next] = dist[now] + 1;
                }
            }
        }



    }
}
