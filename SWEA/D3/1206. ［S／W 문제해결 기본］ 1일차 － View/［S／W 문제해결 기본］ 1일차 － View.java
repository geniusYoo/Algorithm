import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

class Solution {

    private static List<Integer> building;
    private static int [] rx = {-2, -1, 0, 1, 2};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        for (int i = 0; i < 10; i++) {
            int N = Integer.parseInt(br.readLine());
            building = new ArrayList<>();
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int height = Integer.parseInt(st.nextToken());
                building.add(height);
            }
            int idx = i+1;
            System.out.print("#" +  idx + " ");
            printCountsOfHouse();
        }

    }

    public static void printCountsOfHouse() {
        int cnt = 0;
        final int SIZE = building.size();
        for (int i = 2; i < SIZE-2; i++) {
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < 5; j++) {
                list.add(building.get(i + rx[j]));
            }
            if (Collections.max(list) == building.get(i)) {
                list.remove(2);
                int max = Collections.max(list);
                cnt += (building.get(i) - max);
            }
        }
        System.out.println(cnt);
    }
}