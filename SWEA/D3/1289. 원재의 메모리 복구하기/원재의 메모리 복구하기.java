import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Solution {
    private static int T;
    private static int INIT = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            String bitString = br.readLine();
            int res = 0;
            if ((bitString.charAt(0) - '0') != 0) res++;
            int pre = bitString.charAt(0) - '0';

            for (int j = 1; j < bitString.length(); j++) {
                int bit = bitString.charAt(j) - '0';
                if (pre != bit) res++;
                pre = bit;
            }
            System.out.println("#" + (i+1) + " " + res);

        }
    }
}