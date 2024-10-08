import java.io.*;
import java.util.*;

class Main {
    static int N, K;
    static int[] mv = {-1, 1, 0};
    static boolean[] visited = new boolean[100_001];
    static int[] map = new int[100_001];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        System.out.println(bfs(N));
    }
    private static int bfs(int start) {
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        deque.add(start);
        visited[start] = true;

        while(!deque.isEmpty()) {
            int now = deque.pollFirst();
            if (now == K) return map[K];
            mv[2] = now;
            for (int i = 0; i < 3; i++) {
                int next = now + mv[i];

                if (next >= 0 && next <= 100_000 && !visited[next]){
                    visited[next] = true;
                    deque.add(next);
                    map[next] = map[now] + 1;
                }
            }
        }
        return -1;
    }





}


