import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        for (int i=0; i<progresses.length; i++) {
            int period = (100 - progresses[i]) / speeds[i];
            if ((100 - progresses[i]) % speeds[i] > 0) period++;
            deque.addLast(period);
        }
        int prev = deque.pollFirst();
        int idx = 0;
        HashMap<Integer, Integer> answer = new HashMap<>();
        answer.put(idx, 1);
        while (!deque.isEmpty()) {
            int now = deque.pollFirst();
            if (prev < now) {
                idx++;
                answer.put(idx, 1);
                prev = now;
            }
            else {
                answer.put(idx, answer.get(idx) + 1);
            }
        }
        int[] res = new int[answer.size()];
        for (int key : answer.keySet()) {
            res[key] = answer.get(key);
        }
        return res;
    }
}