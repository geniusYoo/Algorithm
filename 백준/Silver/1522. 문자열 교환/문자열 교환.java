import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String alpha = br.readLine();
        int aCnt = 0;
        for (char c : alpha.toCharArray()) {
            if (c == 'a') aCnt++;
        }
        
        int bCnt = 0;
        for (int i = 0; i < aCnt; i++) {
            if (alpha.charAt(i) == 'b') bCnt++;
        }
        int res = bCnt;

        int N = alpha.length();
        for (int i = 1; i < N; i++) {
            if (alpha.charAt(i - 1) == 'b') bCnt--;
            if (alpha.charAt((i + aCnt - 1)%N) == 'b') bCnt++;
            res = Math.min(res, bCnt);
        }

        System.out.println(res);
    }
}