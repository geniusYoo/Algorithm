import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

class Main {
    private static int [] A, arr;
    private static boolean [] used;
    private static int res;
    private static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        A = new int [N];
        arr = new int [N];
        used = new boolean[N];

        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        backtrack(0);
        System.out.println(res);
    }

    public static void backtrack(int cnt) {
        if (cnt == N) {
            int result = 0;
            for (int i = 0; i < N-1; i++) {
                result += (Math.abs(arr[i] - arr[i+1]));
            }
            res = Math.max(result, res);
            return;
        }
        for (int i = 0; i < N; i++) {
            if (!used[i]) {
                used[i] = true;
                arr[cnt] = A[i];
                backtrack(cnt + 1);
                used[i] = false;
            }
        }

    }
}