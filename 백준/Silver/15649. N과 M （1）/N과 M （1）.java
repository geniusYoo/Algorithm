import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    private static boolean [] used;
    private static int [] map;
    public static int N, M;
    public static StringBuilder sb;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        sb = new StringBuilder();
        map = new int[N + 1];
        used = new boolean[N + 1];

        for (int i = 1; i <= N; i++) {
            map[i] = i;
        }

        backtrack("", 0);

        System.out.println(sb.toString());
    }

    public static void backtrack(String s, int cnt) {
        if (cnt == M) {
            sb.append(s.trim());
            sb.append("\n");
            return;
        }

        for (int i = 1; i <= N; i++) {
            if (used[i]) continue;
            used[i] = true;
            backtrack(s + " " + i, cnt + 1);
            used[i] = false;
        }
        
    }
}