import java.util.*;
class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] result = new int[id_list.length];
        HashMap<String, ArrayList<String>> report_to = new HashMap<>();
        HashMap<String, Integer> reported_cnt = new HashMap<>();
        HashSet<String> reported = new HashSet<>();
        
        // 신고 목록 중복 제거
        HashSet<String> reports = new HashSet<>();
        for (String r : report) {
            reports.add(r);
        }
        
        reports.iterator().forEachRemaining(r -> {
            String[] rep = r.split(" ");
            String from = rep[0];
            String to = rep[1];
            report_to.computeIfAbsent(from, repo -> new ArrayList<>()).add(to);
            reported_cnt.put(to, reported_cnt.getOrDefault(to, 0) + 1);
            
            if (reported_cnt.get(to) >= k) reported.add(to);
        });
        
        for (int i=0; i<id_list.length; i++) {
            int cnt = 0;
            
            if (report_to.get(id_list[i]) != null) {
            for (String str : report_to.get(id_list[i])) {
                if (reported.contains(str)) cnt++;    
            }
            }
            
            result[i] = cnt;
        }
        
        
        return result;
    }
}