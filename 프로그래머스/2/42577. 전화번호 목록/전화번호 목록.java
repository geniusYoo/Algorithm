import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public static boolean solution(String[] phone_book) {
        boolean answer = true;
        List<String> list = Arrays.stream(phone_book).collect(Collectors.toList());
        Collections.sort(list);
        for (int i = 0; i < list.size()-1; i++) {
            if (list.get(i).length() <= list.get(i+1).length()) {
                if (list.get(i).equals(list.get(i+1).substring(0, list.get(i).length()))) answer = false;
            }
        }

        return answer;
    }
}