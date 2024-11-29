
class Solution {
    public static String tg;
    public static String[] word;
    public static int ans = Integer.MAX_VALUE;
    public static boolean[] used;

    public static int solution(String begin, String target, String[] words) {
        word = words;
        used = new boolean[words.length];
        tg = target;
        dfs(begin, 0);
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }

    public static void dfs(String s, int cnt) {
        if (s.equals(tg)) {
            ans = Math.min(ans, cnt);
            return;
        }

        for (int i = 0; i < word.length; i++) {
            if (!used[i] && diff(s, word[i])) {
                used[i] = true;
                dfs(word[i], cnt+1);
                used[i] = false;
            }
        }
    }



    public static boolean diff(String from, String to) {
        int diff_cnt = 0;
        for (int i = 0; i < from.length(); i++) {
            if (from.charAt(i) != to.charAt(i)) diff_cnt++;
        }
        return diff_cnt == 1;
    }


}