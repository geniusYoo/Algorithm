import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Burger {
    int score, cal;

    public Burger(int score, int cal) {
        this.score = score;
        this.cal = cal;
    }
}

class Solution {
    private static int N, L;
    private static Burger [] map;
    private static boolean [] used;
    private static List<Integer> scores;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            L = Integer.parseInt(st.nextToken());

            map = new Burger[N];
            used = new boolean[N];
            scores = new ArrayList<>();

            for (int j = 0; j < N; j++) {
                st = new StringTokenizer(br.readLine());
                map[j] = new Burger(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            }
            
            backtrack(0,0, 0);
            
            System.out.println("#" + (i+1) + " "  + Collections.max(scores));
        }
    }

    public static void backtrack(int now_cal, int now_score, int idx) {
        if (now_cal <= L) {
            scores.add(now_score);
        }

        for (int i = idx; i < N; i++) {
            if (now_cal + map[i].cal <= L && !used[i]) {
                used[i] = true;
                backtrack(now_cal + map[i].cal, now_score + map[i].score, i+1);
                used[i] = false;
            }
        }
    }
}