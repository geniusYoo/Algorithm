import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Solution {
    private static int N;
    private static int [] arr; // 인덱스가 열, 값이 행
    private static int cnt;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            cnt = 0;
            N = Integer.parseInt(br.readLine());
            arr = new int [N];

            nQueen(0);
            System.out.println("#" + (i+1) + " " +  cnt);
        }

    }

    public static void nQueen(int depth) {
        if (depth == N) {
            cnt++;
            return;
        }

        for (int i = 0; i < N; i++) {
            arr[depth] = i;

            if (available(depth)) {
                nQueen(depth + 1);
            }
        }
    }

    public static boolean available(int c) {
        for (int i = 0; i < c; i++) {
            // 같은 행에 위치할 경우
            if (arr[c] == arr[i]) return false;

            else if (Math.abs(c - i) == Math.abs(arr[c] - arr[i])) return false;
        }

        return true;
    }
}