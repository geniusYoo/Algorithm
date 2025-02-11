import java.util.*;

class Solution {
    public String solution(int n, int k, String[] cmd) {
        Stack<Integer> gc = new Stack<>();
        int[] up = new int [n+2];
        int[] down = new int [n+2];
        
        for (int i=0; i<n+2; i++) {
            up[i] = i-1;
            down[i] = i+1;
        }
        
        k++;
        
        for (String c : cmd) {
            if (c.startsWith("C")) {
                gc.push(k);
                up[down[k]] = up[k];
                down[up[k]] = down[k];
                k = n < down[k] ? up[k] : down[k];
            }
            else if (c.startsWith("Z")) {
                int recover = gc.pop();
                down[up[recover]] = recover;
                up[down[recover]] = recover;
            }
            else {
                String[] s = c.split(" ");
                int val = Integer.parseInt(s[1]);
                for (int i=0; i<val; i++) {
                    k = s[0].equals("U") ? up[k] : down[k];
                }
            }
        }
        
        char[] ans = new char[n];
        Arrays.fill(ans, 'O');
        for (int i : gc) {
            ans[i-1] = 'X';
        }
        return new String(ans);
    }
}