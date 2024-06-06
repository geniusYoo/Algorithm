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

        PriorityQueue<Integer> gift = new PriorityQueue<>(Collections.reverseOrder());
        List<Integer> child = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            gift.add(Integer.parseInt(st.nextToken()));
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            child.add(Integer.parseInt(st.nextToken()));
        }

        int ans = 1;

        for (Integer c : child) {
            if (c > gift.peek()) {
                ans = 0;
                break;
            }
            int g = gift.poll();
            if (g != c) {
                gift.add(g-c);
            }
        }

        System.out.println(ans);


    }


}
