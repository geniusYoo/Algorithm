import java.util.*;
class Solution {
    public int[] solution(String[] genres, int[] plays) {
        HashMap<String, HashMap<Integer, Integer>> map = new HashMap<>();
        HashMap<String, Integer> score = new HashMap<>();
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < genres.length; i++) {
            score.put(genres[i], score.getOrDefault(genres[i], 0) + plays[i]);
            HashMap<Integer, Integer> sub = map.getOrDefault(genres[i], new HashMap<>());
            sub.put(i, plays[i]);
            map.put(genres[i], sub);
        }
        List<String> keys = new ArrayList<>();
        for (String k : score.keySet()) {
            keys.add(k);
        }
        Collections.sort(keys, (o1, o2) -> score.get(o2).compareTo(score.get(o1)));
        for (String k : keys) {
            List<Integer> tmp = new ArrayList<>();
            for (Integer k2 : map.get(k).keySet()) {
                tmp.add(k2);
            }
            if (tmp.size() < 2) {
                for (Integer k2 : map.get(k).keySet()) {
                    ans.add(k2);
                }
            }
            else {
                Collections.sort(tmp, (o1, o2) -> map.get(k).get(o2).compareTo(map.get(k).get(o1)));
                ans.add(tmp.get(0));
                ans.add(tmp.get(1));
            }
        }
        int[] answer = new int[ans.size()];
        for (int i = 0; i < ans.size(); i++) {
            answer[i] = ans.get(i);
        }
        return answer;
    }
}