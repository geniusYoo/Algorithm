import java.util.*;
class Solution {
    
    private static HashMap<Integer, HashMap<String, Integer>> courseMap;
    public String[] solution(String[] orders, int[] course) {
        courseMap = new HashMap<>();
        for (int i : course) courseMap.put(i, new HashMap<>());
        
        for (String order : orders) {
            char[] orderArr = order.toCharArray();
            Arrays.sort(orderArr);
            combination(0, orderArr, "");
        }
        
        ArrayList<String> ans = new ArrayList<>();
        
        for (HashMap<String, Integer> count : courseMap.values()) {
            count.values()
                .stream()
                .max(Comparator.comparingInt(o -> o))
                .ifPresent(cnt -> count.entrySet()
                           .stream()
                           .filter(entry -> cnt.equals(entry.getValue()) && cnt > 1) 
                            .forEach(entry -> ans.add(entry.getKey())));
        }
        Collections.sort(ans);
        return ans.toArray(new String[0]);
    }
    
    public void combination(int idx, char[] order, String res) {
        if (courseMap.containsKey(res.length())) {
            HashMap<String, Integer> tmp = courseMap.get(res.length());
            tmp.put(res, tmp.getOrDefault(res, 0) + 1);
        }
        
        for (int i=idx; i<order.length; i++) 
            combination(i+1, order, res + order[i]);
        
    }
}