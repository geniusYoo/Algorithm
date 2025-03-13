import java.util.*;

class Solution {
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        HashMap<String, String> parents = new HashMap<>();
        HashMap<String, Integer> money = new HashMap<>();
    
        for (int i=0; i<enroll.length; i++) {
            parents.put(enroll[i], referral[i]);
            money.put(enroll[i], 0);
        }
        
        for (int i=0; i<seller.length; i++) {
            String child = seller[i]; 
            int salary = amount[i] * 100; 
            while (true) {
                if (child.equals("-")) break;
                String parent = parents.get(child); 
                int bonus = salary / 10;
                if (bonus > 0) money.put(child, money.get(child) - bonus + salary);
                else {
                    money.put(child, money.get(child) + salary);
                    break;
                 }
                
                salary = bonus;
                child = parent;
            }
        }
        
        int[] res = new int[enroll.length];
        for (int i=0; i<enroll.length; i++) {
            res[i] = money.getOrDefault(enroll[i], 0);
        }
        
        return res;
    }
}