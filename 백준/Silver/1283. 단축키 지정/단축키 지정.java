import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

class Main {
    static StringBuilder sb = new StringBuilder();
    static HashSet<Character> set = new HashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            String[] splited = s.split(" ");
            if (!option1(splited)) {
                option2(s);
            }
        }
        System.out.print(sb.toString().trim());  // 마지막 공백 제거
    }

    public static boolean option1(String[] words) {
        for (int i = 0; i < words.length; i++) {
            char firstChar = Character.toLowerCase(words[i].charAt(0));
            if (!set.contains(firstChar)) {  // 단축키로 사용되지 않은 경우
                set.add(firstChar);
                appendWithShortcut(words, i);
                return true;
            }
        }
        return false;
    }

    public static void option2(String s) {
        boolean found = false;
        for (int i = 0; i < s.length(); i++) {
            char c = Character.toLowerCase(s.charAt(i));
            if (!found && !set.contains(c) && s.charAt(i) != ' ') {
                set.add(c);
                sb.append("[").append(s.charAt(i)).append("]");
                found = true;
            } else {
                sb.append(s.charAt(i));
            }
        }
        sb.append("\n");
    }

    private static void appendWithShortcut(String[] words, int index) {
        for (int i = 0; i < words.length; i++) {
            if (i == index) {
                sb.append("[").append(words[i].charAt(0)).append("]")
                  .append(words[i].substring(1));
            } else {
                sb.append(words[i]);
            }
            if (i < words.length - 1) sb.append(" ");
        }
        sb.append("\n");
    }
}
