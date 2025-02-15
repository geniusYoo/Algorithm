import java.util.*;
class Solution {
    public static int solution(String[][] clothes) {
        int answer = 1;
        HashMap<String, Integer> map = new HashMap<>();
        for (String[] cloth : clothes) {
            int cnt = map.getOrDefault(cloth[1], 0);
            cnt++;
            map.put(cloth[1], cnt);
        }
        for (String key : map.keySet()) {
            answer *= (map.get(key)+1);
        }
        
        return answer-1;
    }
}