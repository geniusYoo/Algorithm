import java.util.*;

class Node {
    int x;
    int y;
    int num;
    Node left; 
    Node right;
    public Node (int x, int y, int num) {
        this.x = x;
        this.y = y;
        this.num = num;
    }
}
class Solution {
    public int[][] solution(int[][] nodeinfo) {
        Node[] nodes = new Node[nodeinfo.length];
        for (int i=0; i<nodeinfo.length; i++) {
            nodes[i] = new Node(nodeinfo[i][0], nodeinfo[i][1], i+1);
        }
        
        // y 레벨로 먼저 돌고 각 레벨에서는 x가 루트보다 큰지 작은지로 오른쪽 왼쪽 노드 나누면 됨
        Arrays.sort(nodes, (o1, o2) -> {
            if (o1.y == o2.y) return Integer.compare(o1.x, o2.x);
            return Integer.compare(o2.y, o1.y);
        });
        
        Node root = nodes[0];
        for (int i=1; i<nodes.length; i++) {
            Node parent = root;
            while (true) {
                if (nodes[i].x < parent.x) {
                    if(parent.left == null) {
                        parent.left = nodes[i];
                        break;
                    }
                    else {
                        parent = parent.left;
                    }
                }
                else {
                    if (parent.right == null) {
                        parent.right = nodes[i];
                        break;
                    }
                    else {
                        parent = parent.right;
                    }
                }
            }
        }
        ArrayList<Integer> postOrderList = new ArrayList<>();
        postOrder(root, postOrderList);
        ArrayList<Integer> preOrderList = new ArrayList<>();
        preOrder(root, preOrderList);
        
        int[][] answer = new int[2][nodeinfo.length];
        answer[0] = preOrderList.stream().mapToInt(Integer::intValue).toArray();
        answer[1] = postOrderList.stream().mapToInt(Integer::intValue).toArray();
            
        return answer;
    }
    
    private static void postOrder(Node cur, ArrayList<Integer> ans) {
        if (cur == null) return;
        
        postOrder(cur.left, ans);
        postOrder(cur.right, ans);
        ans.add(cur.num);
    }
    
    private static void preOrder(Node cur, ArrayList<Integer> ans) {
        if (cur == null) return;
        
        ans.add(cur.num);
        preOrder(cur.left, ans);
        preOrder(cur.right, ans);
    }
}