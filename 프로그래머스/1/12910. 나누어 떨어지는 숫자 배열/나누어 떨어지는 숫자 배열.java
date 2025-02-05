import java.util.*;
class Solution {
    public int[] solution(int[] arr, int divisor) {
        
        ArrayList<Integer> res = new ArrayList<>();
        for (int element : arr) {
            if (element % divisor == 0) res.add(element);
        }
        if (res.size() < 1) {
            int[] answer = new int[1];
            answer[0] = -1;
            return answer;
        }
        else {
            int[] answer = new int[res.size()];
            Collections.sort(res);

            for (int i=0; i<res.size(); i++) {
                answer[i] = res.get(i);
            }
            return answer;
        }
    }
}