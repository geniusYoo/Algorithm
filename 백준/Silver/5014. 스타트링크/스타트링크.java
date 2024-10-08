import java.io.*;
import java.util.*;

class Main {
    static int F,S,G,U,D;
    static int[] mv = {0,0};
    static boolean[] visited = new boolean[100_000_1];
    static int[] map = new int[100_000_1];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        F = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        G = Integer.parseInt(st.nextToken());
        U = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());
        mv[0] = U;
        mv[1] = -D;
        bfs(S);
    }
    private static void bfs(int start) {
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        deque.add(start);
        visited[start] = true;

        while(!deque.isEmpty()) {
            int now = deque.pollFirst();
            if (now == G) {
                System.out.println(map[G]);
                return;
            }

            for (int i = 0; i < 2; i++) {
                int next = now + mv[i];

                if (next > 0 && next <= F && !visited[next]){
                    visited[next] = true;
                    deque.add(next);
                    map[next] = map[now] + 1;
                }
            }
        }
        System.out.println("use the stairs");
    }





}


