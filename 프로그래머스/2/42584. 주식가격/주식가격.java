import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        int n = prices.length;
        int[] answer = new int[n];
        
        Stack<Integer> stack = new Stack<>();
        stack.push(0); // 초기 인덱스
        
        for (int i=1; i<prices.length; i++) {
            while (!stack.isEmpty() && prices[stack.peek()] > prices[i]) {
                int popped = stack.pop();
                answer[popped] = i - popped;
            }
            stack.push(i);
        }
        
        while (!stack.isEmpty()) {
            int poppedIdx = stack.pop();
            answer[poppedIdx] = n - poppedIdx - 1;
        }
        return answer;
    }
}