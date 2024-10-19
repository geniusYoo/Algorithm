import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] num = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }
        HashMap<Integer, Integer> map = new HashMap<>();

        int left = 0;
        int res = 0;

        for (int right = 0; right < N; right++) {
            map.put(num[right], map.getOrDefault(num[right], 0)+1);

            while (map.get(num[right]) > K) {
                map.put(num[left], map.get(num[left]) -1);
                left++;
            }

            res = Math.max(res, right - left + 1);

        }

        System.out.println(res);
    }
}