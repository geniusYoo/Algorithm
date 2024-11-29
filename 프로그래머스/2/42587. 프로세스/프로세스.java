import java.util.ArrayDeque;

class Node {
    int idx, val;
    public Node(int idx, int val){
        this.idx = idx;
        this.val = val;
    }
}
class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;

        ArrayDeque<Node> deque = new ArrayDeque<>();
        boolean[] used = new boolean[priorities.length];
        int[] res = new int[priorities.length];
        for (int i = 0; i < priorities.length; i++) {
            deque.addLast(new Node(i, priorities[i]));
        }

        int order = 0;
        while(!deque.isEmpty()) {
            Node now = deque.pollFirst();
            used[now.idx] = true;
            order++;
            
            for (int i = 0; i < priorities.length; i++) {
                if (now.val < priorities[i] && !used[i]) {
                    deque.addLast(now);
                    used[now.idx] = false;
                    order--;
                    break;
                }
            }
            res[now.idx] = order;
            
        }
        
        return res[location];
    }
}