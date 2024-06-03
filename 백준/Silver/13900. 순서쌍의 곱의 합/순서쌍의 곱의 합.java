import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int[] num = new int[N];
        long[] ps = new long[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }

        ps[0] = num[0];
        for (int i = 1; i < N; i++) {
            ps[i] = ps[i-1] + num[i];
        }

        long sum = 0;
        for (int i = N-1; i > 0; i--) {
            sum += num[i] * ps[i-1];
        }
        System.out.println(sum);
    }
}
