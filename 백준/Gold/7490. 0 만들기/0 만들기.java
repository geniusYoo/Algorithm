import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static String[] commands = {" ", "+", "-"};
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            N = Integer.parseInt(br.readLine());
            backtrack(1,  "1");
            System.out.println();
        }
    }

    public static void backtrack(int before, String s) {
        if (before == N) {
            if (calculate(s) == 0) System.out.println(s);
            return;
        }

        for (int i = 0; i < 3; i++) {
            backtrack(before+1, s + commands[i] + (before+1));
        }
    }

    public static int calculate(String s) {
        int sum = 0;
        int sign = 1;
        int currentNumber = 0;
        s = s.replaceAll(" ", ""); // 모든 공백 제거

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '+') {
                sum += sign * currentNumber;
                sign = 1;
                currentNumber = 0;
            } else if (c == '-') {
                sum += sign * currentNumber;
                sign = -1;
                currentNumber = 0;
            } else {
                currentNumber = currentNumber * 10 + (c - '0');
            }
        }
        sum += sign * currentNumber;
        return sum;
    }
}