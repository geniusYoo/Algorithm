import java.util.*;
class Solution {
    public int[] solution(int[] answers) {
        int[] answer = new int[3];
        answer[0] = solve1(answers);
        answer[1] = solve2(answers);
        answer[2] = solve3(answers);
        int max = Math.max(answer[0], Math.max(answer[1], answer[2]));
        ArrayList<Integer> ans = new ArrayList<>();
        for (int i=0; i<3; i++) {
            if(answer[i] == max) ans.add(i+1);
        }
        Collections.sort(ans);
        
        return ans.stream().mapToInt(Integer::intValue).toArray();
        
    }
    
    public int solve1(int[] answers) {
        int res = 0;
        int[] solved = {1, 2, 3, 4, 5};
        for (int i=0; i<answers.length; i++) {
            if (solved[i%5] == answers[i]) res++;
        }
        return res;
    }
    
    public int solve2(int[] answers) {
        int res = 0;
        int[] solved = {2, 1, 2, 3, 2, 4, 2, 5};
        for (int i=0; i<answers.length; i++) {
            if (solved[i%8] == answers[i]) res++;
        }
        return res;
    }
    
    public int solve3(int[] answers) {
        int res = 0;
        int[] solved = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        for (int i=0; i<answers.length; i++) {
            if (solved[i%10] == answers[i]) res++;
        }
        return res;
    }
}