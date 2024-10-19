import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String balls = br.readLine();
        int res = Integer.MAX_VALUE;

        // left, R
        int tmp = 0;
        boolean flag = false;

        for (int i = 0; i < N; i++) {
            if (flag && balls.charAt(i) == 'R') tmp++;
            if (balls.charAt(i) == 'B') flag = true;
        }
        res = Math.min(res, tmp);

        // left, B
        tmp = 0;
        flag = false;
        for (int i = 0; i < N; i++) {
            if (flag && balls.charAt(i) == 'B') tmp++;
            if (balls.charAt(i) == 'R') flag = true;
        }
        res = Math.min(res, tmp);

        // right, R
        tmp = 0;
        flag = false;
        for (int i = N-1; i >= 0; i--) {
            if (flag && balls.charAt(i) == 'R') tmp++;
            if (balls.charAt(i) == 'B') flag = true;
        }
        res = Math.min(res, tmp);

        // right, B
        tmp = 0;
        flag = false;
        for (int i = N-1; i >= 0; i--) {
            if (flag && balls.charAt(i) == 'B') tmp++;
            if (balls.charAt(i) == 'R') flag = true;
        }
        res = Math.min(res, tmp);
        
        System.out.println(res);
    }
}