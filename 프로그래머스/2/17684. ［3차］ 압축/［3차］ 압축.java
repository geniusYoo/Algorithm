import java.util.*;

class Solution {
    public int[] solution(String msg) {
        HashMap<String, Integer> dict = new HashMap<>();
        for (int i = 0; i < 26; i++) {
            dict.put("" + (char)('A' + i), i + 1);
        }
        ArrayList<Integer> ans = new ArrayList<>();
        int now = 0;
        while (now < msg.length()) {
            int next = now + 1;
            String cur = msg.substring(now, next);
            
            while (next <= msg.length() && dict.containsKey(msg.substring(now, next))) {
                cur = msg.substring(now, next);
                next++;
            }
            
            ans.add(dict.get(cur));

            if (next <= msg.length()) {
                String newEntry = msg.substring(now, next);
                dict.put(newEntry, dict.size() + 1);
            }
            
            now += cur.length();
        }
        int[] answer = new int[ans.size()];
        for (int i=0; i<ans.size(); i++) {
            answer[i] = ans.get(i);
        }
        return answer;
    }
}