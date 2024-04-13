import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

class Main {
    private static final int [] rx = {-1, 0, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int [] height = new int [N];
        long [] cnt = new long [N];
        long result = 0;
        for (int i = 0; i < N; i++) {
            height[i] = Integer.parseInt(br.readLine());
        }

        for (int i = 0; i < N - 1; i++) {
            for (int j = i+1; j < N; j++) {
                if (height[i] <= height[j]) {
                    break;
                }
                cnt[i]++;
            }
        }

        for (int i = 0; i < N; i++) {
            result += cnt[i];
        }

        System.out.println(result);

    }
}