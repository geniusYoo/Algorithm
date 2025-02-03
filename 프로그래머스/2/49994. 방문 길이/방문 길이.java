import java.util.*;

class Solution {
    private static boolean validation(int nx, int ny) {
        return nx >= 0 && nx < 11 && ny >= 0 && ny < 11;
    }
    private static HashMap<Character, int[]> location = new HashMap<>();
    
    private static void init() {
        location.put('U', new int[]{0, 1});
        location.put('D', new int[]{0, -1});
        location.put('R', new int[]{1, 0});
        location.put('L', new int[]{-1, 0});
    }
    public int solution(String dirs) {
        
        init();
        int x = 5;
        int y = 5;
        
        HashSet<String> answer = new HashSet<>();
        for (int i=0; i<dirs.length(); i++) {
            int[] offset = location.get(dirs.charAt(i));
            
            int nx = x + offset[0];
            int ny = y + offset[1];
            
            if (!validation(nx, ny)) continue;
            
            answer.add(x + " " + y + " " + nx + " " + ny + " ");
            answer.add(nx + " " + ny + " " + x + " " + y + " ");
            x = nx;
            y = ny;
        }
        return answer.size()/2;
    }
}