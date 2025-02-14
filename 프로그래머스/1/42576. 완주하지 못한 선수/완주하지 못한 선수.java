import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        HashMap<String, Integer> challengers = new HashMap<>();
        for (String c : completion) challengers.put(c, challengers.getOrDefault(c, 0) + 1);
        for (String p : participant) {
            if (!challengers.containsKey(p)) {
                return p;
            }
            else {
                challengers.put(p, challengers.get(p) - 1);
            }
        }
        
        for (String key : challengers.keySet()) {
            if (challengers.get(key) < 0) return key;
        }
        
        
        return null;
    }
}