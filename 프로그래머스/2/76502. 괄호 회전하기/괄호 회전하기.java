import java.util.*;

class Solution {
    static HashMap<Character, Character> offset = new HashMap<>();
    public int solution(String s) {
        offset.put('[', ']');
        offset.put('{', '}');
        offset.put('(', ')');
        StringBuilder sb = new StringBuilder();
        int answer = 0;
        for (int i=0; i<s.length(); i++) {
            sb.append(s.charAt(i));
        }
        
        if (validate(s)) answer++;
        
        for (int i=0; i<s.length()-1; i++) {
            sb.deleteCharAt(0);
            sb.append(s.charAt(i));
            if(validate(sb.toString())) answer++;
        }
        
        
        return answer;
    }
    public boolean validate(String s) {
        Stack<Character> stack = new Stack<>();
        // 괄호가 올바른지 검사
        for (int i=0; i<s.length(); i++) {
            char target = s.charAt(i);
            // 열려 있는 괄호는 스택에 push
            if (offset.containsKey(target)) stack.push(target);
            
            // 닫혀 있는 괄호는 스택에 있는지 검사
            else {
                if(!stack.isEmpty() && offset.get(stack.peek()).equals(target)) stack.pop();
                else return false;
            }
        }
        return stack.isEmpty();
    }
}