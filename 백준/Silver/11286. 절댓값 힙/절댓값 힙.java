import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

class Main {
    public static PriorityQueue<Integer> pos_pq = new PriorityQueue<>();
    public static PriorityQueue<Integer> neg_pq = new PriorityQueue<>(Collections.reverseOrder());

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int cnt = Integer.parseInt(br.readLine());
        for (int i = 0; i < cnt; i++) {
            int num = Integer.parseInt(br.readLine());
            if (num == 0) excute();
            else if (num > 0) pos_pq.add(num);
            else if (num < 0) neg_pq.add(num);
        }

    }
    public static void excute() {
        // 둘다 비어있지 않으면 실행
        if (!pos_pq.isEmpty() && !neg_pq.isEmpty()) {
            int pos = pos_pq.peek();
            int neg = neg_pq.peek();
            // 두개의 절댓값이 같으면 음수 pq poll
            if (Math.abs(pos) == Math.abs(neg)) System.out.println(neg_pq.poll());

            // 이외에는 절대값이 작은 수를 반환
            else if (Math.abs(pos) < Math.abs(neg)) System.out.println(pos_pq.poll());
            else System.out.println(neg_pq.poll());
        }

        // 둘다 비어있으면
        else if (pos_pq.isEmpty() && neg_pq.isEmpty()) System.out.println(0);
        else if (pos_pq.isEmpty()) System.out.println(neg_pq.poll());
        else if (neg_pq.isEmpty()) System.out.println(pos_pq.poll());
    }


}
