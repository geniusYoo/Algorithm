import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Road {
    int num, val;
    public Road (int num, int val) {
        this.num = num;
        this.val = val;
    }
}
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        ArrayList<Road>[] adjList = new ArrayList[N+1];
        for (int i = 0; i < N+1; i++) {
            adjList[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());
            adjList[A].add(new Road(B, C));
            adjList[B].add(new Road(A, C));
        }

        ArrayDeque<Road> deque = new ArrayDeque<>();
        int[] dist = new int[N+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        deque.addLast(new Road(1, 0));
        dist[1] = 0;
        while(!deque.isEmpty()) {
            Road now = deque.pollFirst();

            if (now.val > dist[now.num]) continue;

            for (Road next : adjList[now.num]) {
                if (now.val + next.val < dist[next.num]) {
                    dist[next.num] = next.val + now.val;
                    deque.addLast(new Road(next.num, next.val + now.val));
                }

            }
        }

        System.out.println(dist[N]);
    }
}
