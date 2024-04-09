import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int [] number = new int [N];
        for (int i = 0; i < N; i++) {
            number[i] = Integer.parseInt(br.readLine());
        }

        // 1. 산술평균 -> Math.round
        double avg = 0;
        for (int i = 0; i < N; i++) {
            avg += number[i];
        }
        System.out.println(Math.round(avg / (double)N));

        // 2. 중앙값
        Arrays.sort(number);
        System.out.println(number[(N/2)]);


        // 3. 최빈값
        // 오름차순으로 정렬된 상태이므로 -2 1 1 2 3 8

        TreeMap<Integer, Integer> tree = new TreeMap<>();

        for (int i = 0; i < N; i++) {
            tree.put(number[i], 0);
        }
        for (int i = 0; i < N; i++) {
            int cnt = tree.get(number[i]) + 1;
            tree.put(number[i], cnt);
        }

        List<Integer> list = new ArrayList<>();
        int max = tree.get(number[0]);
        for (Integer v : tree.values()) {
            max = Math.max(v, max);
        }

        for (Integer key : tree.keySet()) {
            if (max == tree.get(key)) list.add(key);
        }

        if (list.size() > 1) {
            Collections.sort(list);
            System.out.println(list.get(1));
        }
        else {
            System.out.println(list.get(0));
        }

        // 4 : 범위
        int diff = number[N-1]-number[0];
        System.out.println(diff);

    }
}