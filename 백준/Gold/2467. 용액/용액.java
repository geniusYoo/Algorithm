import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] liquid = new int[N];
        for (int i = 0; i < N; i++) {
            liquid[i] = Integer.parseInt(st.nextToken());
        }

        int left = 0;
        int right = N - 1;
        int res = Integer.MAX_VALUE;
        int[] resIdx = new int[2];
        while (left != right) {
            int sum = liquid[left] + liquid[right];
            int absoluteSum = Math.abs(sum);
            if (res > absoluteSum) {
                res = absoluteSum;
                resIdx[0] = left;
                resIdx[1] = right;
                if (sum == 0) {
                    System.out.println(liquid[resIdx[0]] + " " + liquid[resIdx[1]]);
                    return;
                }
            }
            if (sum < 0) left++;
            if (sum > 0) right--;
        }
        System.out.println(liquid[resIdx[0]] + " " + liquid[resIdx[1]]);
    }
}
