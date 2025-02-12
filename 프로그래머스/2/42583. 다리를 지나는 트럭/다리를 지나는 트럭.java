import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        int time = 0;
        int sum = 0;
        for (int truck : truck_weights) {
            while (true) {
                if (deque.isEmpty()) {
                    deque.addLast(truck);
                    sum += truck;
                    time++;
                    break;
                }
                else if (deque.size() == bridge_length) {
                    sum -= deque.pollFirst();
                } else {
                    if (sum + truck <= weight) {
                        deque.addLast(truck);
                        sum += truck;
                        time++;
                        break;
                    }
                    else {
                        deque.addLast(0);
                        time++;
                    }

                }
            }
        }
        return time + bridge_length;
    }
}