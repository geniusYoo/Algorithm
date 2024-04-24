import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

class Solution {
    private static StringTokenizer st;
    private static List<Integer> box;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int T = 0; T < 10; T++) {
            int dump = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());

            box = new ArrayList<>();
            int res = 0;

            for (int j = 0; j < 100; j++) {
                box.add(Integer.parseInt(st.nextToken()));
            }
            for (int i = 0; i < dump; i++) {
                Collections.sort(box);
                int min = box.get(0) + 1;
                int max = box.get(box.size()-1) - 1;

                if (max - min < 2) break;
                box.set(0, min);
                box.set(box.size()-1, max);
            }
            System.out.println("#" + (T+1) + " " + (Collections.max(box) - Collections.min(box)));


        }

    }
}