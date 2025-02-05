import java.util.*;
class Solution {
    public int[] solution(int n, long left, long right) {
        int range = (int)(right-left+1);
        int[] answer = new int[range];
        
        int idx = 0;
        while (left >=0 && left <= right) {
            long r = left/n + 1;
            long c = left%n + 1;
            answer[idx] = (int)Math.max(r,c);
            left++;
            idx++;
        }
        
        return answer;
    }
}