import org.w3c.dom.Node;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


class Main {
    private static int N,M;
    private static StringBuilder sb = new StringBuilder();
    private static boolean [] used;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        used = new boolean[N+1];

        backtrack(0, "",1);
        System.out.println(sb);
    }
    private static void backtrack(int cnt, String s, int pre) {
        if (cnt == M) {
            sb.append(s.trim() + "\n");
            return;
        }
        for (int i = pre; i <= N; i++) {
            if (!used[i]) {
                used[i] = true;
                int k = i;
                backtrack(cnt+1, s + " " + i, k);
                used[i] = false;
            }

        }
    }
}