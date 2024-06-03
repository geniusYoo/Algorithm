import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] pies = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            pies[i] = Integer.parseInt(st.nextToken());
        }

        int sum = 0;
        for (int i = 0; i < K; i++) {
            sum += pies[i];
        }
        int max = sum;

        int left = 0;
        int right = K-1;

        while (left <= N) {
            right = right + (1 % N);
            sum = sum - pies[left%N] + pies[right%N];
            left++;
            max = Math.max(sum, max);
        }
        System.out.println(max);
    }
}
