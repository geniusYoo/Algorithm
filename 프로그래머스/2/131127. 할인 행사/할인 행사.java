import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {        
        HashMap<String, Integer> wants = new HashMap<>();
        int answer = 0;
        for (int i=0; i<want.length; i++) wants.put(want[i], number[i]);
        for (int i=0; i<discount.length - 9; i++) {
            HashMap<String, Integer> discountFor10days = new HashMap<>();
            for (int j=i; j<i+10; j++) {
                discountFor10days.put(discount[j], discountFor10days.getOrDefault(discount[j], 0) + 1);
            }
            
            boolean flag = true;
            for (String w : want) {
                if (discountFor10days.getOrDefault(w, 0) != wants.get(w)) {
                    flag = false;
                    break;
                }
            }
            if (flag) answer++;
        }
        
        
        return answer;
    }
}