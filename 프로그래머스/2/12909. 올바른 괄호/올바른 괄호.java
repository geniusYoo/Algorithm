import java.util.*;

class Solution {
    boolean solution(String s) {
        boolean answer = true;
        Stack<Character> stack = new Stack<>();
        for (int i=0; i<s.length(); i++) {
            if(!stack.isEmpty()) {
                Character bracket = s.charAt(i);
                if (bracket.equals(')') && stack.peek().equals('(')) {
                    stack.pop();
                }
                
                else {
                    stack.push(bracket);
                }
            }
            else stack.push(s.charAt(i));
        }
        
        return stack.size() == 0;
    }
}