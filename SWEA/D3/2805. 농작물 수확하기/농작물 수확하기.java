import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution {
    private static int N;
    private static int [][] map; // 인덱스가 열, 값이 행

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            N = Integer.parseInt(br.readLine());
            map = new int [N][N];
            for (int j = 0; j < N; j++) {
                String num = br.readLine();

                for (int k = 0; k < N; k++) {
                    map[j][k] = num.charAt(k) - '0';
                }

            }

            System.out.println("#" + (i+1) + " "  + calculate());
        }

    }

    public static int calculate() {
        int res = 0;
        int idx = N / 2;

        for (int i = 0; i < N; i++) {
            if (i <= N/2) {
                for (int j = idx - i; j <= idx + i; j++) {
                    res += map[i][j];
                }
            }

            else {
                int range = (N/2 - (i - N/2));
                for (int j = idx - range; j <= idx + range ; j++) {
                    res += map[i][j];
                }
            }
        }
        return res;
    }

}