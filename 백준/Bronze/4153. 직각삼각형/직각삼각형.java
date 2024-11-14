import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        while (true) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());

            if (A == 0 && B == 0 && C == 0) return;

            List<Integer> number = new ArrayList<>();
            number.add(A);
            number.add(B);
            number.add(C);
            Collections.sort(number);
            if (Math.pow(number.get(2), 2) == Math.pow(number.get(0), 2) + Math.pow(number.get(1), 2))
                System.out.println("right");
            else System.out.println("wrong");
        }
    }

}