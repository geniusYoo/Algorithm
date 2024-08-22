
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<Integer> num = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            num.add(Integer.parseInt(br.readLine()));
        }
        Collections.sort(num);
        for (int i = 0; i < N; i++) {
            System.out.println(num.get(i));
        }


    }
}


