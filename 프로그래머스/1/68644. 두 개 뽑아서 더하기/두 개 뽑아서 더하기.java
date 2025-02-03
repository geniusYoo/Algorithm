import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        
        TreeSet<Integer> tree = new TreeSet<>();
        for(int i=0; i<numbers.length-1; i++) {
            for(int j=i+1; j<numbers.length; j++) {
                tree.add(numbers[i] + numbers[j]);
            }
        }
        int[] ans = new int[tree.size()];
        for (int i=0; i<ans.length; i++) {
            ans[i] = tree.pollFirst();
        }
        return ans;
    }
}