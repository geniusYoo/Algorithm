import java.util.HashMap;

class Solution {
    public String solution(String[] participant, String[] completion) {
        HashMap<String, Integer> map = new HashMap<>();
        for (String p : participant) {
            int v = map.get(p) == null ? 0 : map.get(p);
            v++;
            map.put(p, v);
        }
        for (String c : completion) {
            if (map.containsKey(c)) {
                int v = map.get(c);
                v--;
                map.put(c, v);
            }
        }
        for (String key : map.keySet()) {
            if (map.get(key) != 0) return key;
        }
        return null;
    }
}