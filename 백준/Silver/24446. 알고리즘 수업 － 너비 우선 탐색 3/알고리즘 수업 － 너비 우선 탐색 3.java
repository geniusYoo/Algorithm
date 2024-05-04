import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());
        List<Integer>[] map = new ArrayList [N+1];
        for (int i = 0; i <= N; i++) {
            map[i] = new ArrayList<>();
        }
        boolean [] visited = new boolean[N+1];
        int [] depth = new int [N+1];
        Arrays.fill(depth, -1);
        ArrayDeque<Integer> deque = new ArrayDeque<>();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            map[x].add(y);
            map[y].add(x);
        }

        deque.addLast(R);
        visited[R] = true;
        depth[R] = 0;

        while (!deque.isEmpty()) {
            int now = deque.pollFirst();

            for (int i = 0; i < map[now].size(); i++) {
                if (!visited[map[now].get(i)]) {
                    deque.addLast(map[now].get(i));
                    visited[map[now].get(i)] = true;
                    depth[map[now].get(i)] = depth[now] + 1;
                }
            }
        }

        for (int i = 1; i <= N; i++) {
            System.out.println(depth[i]);
        }
    }



}