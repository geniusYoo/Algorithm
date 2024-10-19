import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        int[] time = new int[100_001];
        Arrays.fill(time, Integer.MAX_VALUE);
        deque.addFirst(N);
        time[N] = 0;

        while (!deque.isEmpty()) {
            int now = deque.pollFirst();
            if (now == K) {
                System.out.println(time[now]);
                return;
            }

            if (now * 2 <= 100_001 && time[now * 2] > time[now]) {
                time[now * 2] = time[now];
                deque.addFirst(now * 2);
            }

            if (now - 1 >= 0 && time[now - 1] > time[now] + 1) {
                time[now - 1] = time[now] + 1;
                deque.addLast(now - 1);
            }

            if (now + 1 <= 100_000 && time[now + 1] > time[now] + 1) {
                time[now + 1] = time[now] + 1;
                deque.addLast(now + 1);
            }
        }
    }
}
