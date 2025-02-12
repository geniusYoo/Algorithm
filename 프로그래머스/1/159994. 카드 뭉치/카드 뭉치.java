import java.util.*;

class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        
        ArrayDeque<String> deque1 = new ArrayDeque<>();
        ArrayDeque<String> deque2 = new ArrayDeque<>();
        for (int i=0; i<cards1.length; i++) deque1.addLast(cards1[i]);
        for (int i=0; i<cards2.length; i++) deque2.addLast(cards2[i]);
        
        for (int i=0; i<goal.length; i++) {
            if (!deque1.isEmpty() && goal[i].equals(deque1.peek())) deque1.pollFirst();
            else if (!deque2.isEmpty() && goal[i].equals(deque2.peek())) deque2.pollFirst();
            else return "No";
        }
        return "Yes";
    }
}