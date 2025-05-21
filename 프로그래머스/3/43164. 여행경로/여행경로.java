import java.util.*;

class Solution {
    static boolean[] visited;
    static List<String> res = new ArrayList<>();
    public String[] solution(String[][] tickets) {
        visited = new boolean[tickets.length];
        dfs(tickets, "ICN", "ICN", 0);
        Collections.sort(res);
        return res.get(0).split(" ");
    }
    public void dfs (String[][] tickets, String path, String now, int idx) {
        if (idx == tickets.length) {
            res.add(path);
            return;
        }
        
        for (int i=0; i<tickets.length; i++) {
            if(!visited[i] && tickets[i][0].equals(now)) {
                visited[i] = true;
                dfs(tickets, path + " " + tickets[i][1], tickets[i][1], idx + 1);
                visited[i] = false;
            }
        }
    }
}