import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        int n = prices.length;
        int[] answer = new int[n];
        // 스택의 값은 prices의 인덱스
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        
        for (int i=1; i<prices.length; i++) {
            while (!stack.isEmpty() && prices[i] < prices[stack.peek()]) {
                int k = stack.pop();
                answer[k] = i-k;
            }
            stack.push(i);
        }
        
        while (!stack.isEmpty()) {
            int k = stack.pop();
            answer[k] = n - k - 1;
        }
        
        return answer;
    }
}