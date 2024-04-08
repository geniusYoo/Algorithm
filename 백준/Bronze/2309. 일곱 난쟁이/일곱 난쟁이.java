import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

class Main {
    private final static int N = 9;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            list.add(Integer.parseInt(br.readLine()));
        }
        Collections.sort(list);

        for (int i = 0; i < N - 1; i++) {

            for (int j = i + 1; j < N ; j++) {
                int sum = 0;
                for (int k = 0; k < N; k++) {
                    if (k == i || k == j) continue;
                    sum += list.get(k);
                }
                if (sum == 100) {
                    for (int p = 0; p < N; p++) {
                        if (p == i || p == j) continue;
                        System.out.println(list.get(p));
                    }
                    return;
                }

            }
        }


        
    }
}