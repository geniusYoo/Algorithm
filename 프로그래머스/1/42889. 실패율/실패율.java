import java.util.*;

class Solution {
    public int[] solution(int N, int[] stages) {
        // 도전했는데 실패한 수
        int[] challenger = new int[N + 2];
        for (int i=0; i<stages.length; i++) {
            challenger[stages[i]] += 1;
        }
        HashMap<Integer, Double> fails = new HashMap<>();
        // 모든 사용자는 1스테이지 이상이니까
        double total = stages.length;
        
        // 실패율 계산
        for (int i=1; i<=N; i++) {
            if(challenger[i] == 0) fails.put(i, 0.);
            
            else {
                fails.put(i, challenger[i] / total);
                total -= challenger[i];
            }
        }
        
        return fails.entrySet().stream().sorted((o1, o2) -> Double.compare(o2.getValue(), o1.getValue())).mapToInt(HashMap.Entry::getKey).toArray();
    }
}