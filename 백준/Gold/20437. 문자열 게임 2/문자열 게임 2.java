import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            String W = br.readLine();
            int K = Integer.parseInt(br.readLine());

            ArrayList<Integer>[] indices = new ArrayList['z' - 'a' + 1];
            for (int k = 0; k < 26; k++) {
                indices[k] = new ArrayList<>();
            }
            char[] chars = W.toCharArray();
            for (int j = 0; j < W.length(); j++) {
                indices[chars[j] - 'a'].add(j);
            }

            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;
            boolean resFlag = false;

            for (int j = 0; j < indices.length; j++) {
                if (!indices[j].isEmpty() && indices[j].size() >= K) {
                    resFlag = true;
                    int left = 0;
                    int right = K - 1;
                    while (right != indices[j].size()) {
                        min = Math.min(min, indices[j].get(right) - indices[j].get(left) + 1);
                        max = Math.max(max, indices[j].get(right) - indices[j].get(left) + 1);
                        left++;
                        right++;
                    }
                }
            }
            if (!resFlag) System.out.println(-1);
            else System.out.println(min + " " + max);
        }
    }
}
