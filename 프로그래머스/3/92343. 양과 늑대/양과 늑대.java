import java.util.*;

class Info {
    int node;
    int sheep;
    int wolf;
    HashSet<Integer> visited;
    
    public Info (int node, int sheep, int wolf, HashSet<Integer> visited) {
        this.node = node;
        this.sheep = sheep;
        this.wolf = wolf;
        this.visited = visited;
    }
}
class Solution {
    public int solution(int[] info, int[][] edges) {
        ArrayList<Integer>[] adjList = new ArrayList[info.length];
        for (int i=0; i<info.length; i++) adjList[i] = new ArrayList<>();
        for (int[] edge : edges) adjList[edge[0]].add(edge[1]);
        
        ArrayDeque<Info> deque = new ArrayDeque<>();
        deque.addLast(new Info(0, 1, 0, new HashSet<>()));
        int ans = 0;
        
        while (!deque.isEmpty()) {
            Info now = deque.pollFirst();
            ans = Math.max(ans, now.sheep);
            now.visited.addAll(adjList[now.node]);
            
            for (int next : now.visited) {
                HashSet<Integer> set = new HashSet<>(now.visited);
                set.remove(next);
                if (info[next] == 1) { // wolf
                    if (now.sheep != now.wolf + 1) {
                        deque.addLast(new Info(next, now.sheep, now.wolf + 1, set));
                    }                    
                }
                else {
                    deque.addLast(new Info(next, now.sheep + 1, now.wolf, set));
                }
            }
            
        }
        return ans;
    }
}