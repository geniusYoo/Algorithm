import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

class Max {
    int num, idx;

    public Max(int num, int idx) {
        this.num = num;
        this.idx = idx;
    }
}

class Solution {
    private static StringTokenizer st;
    private static int max;
    private static int change;
    private static int [] numberArr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            String number = st.nextToken();
            numberArr = new int [number.length()];
            for (int j = 0; j < numberArr.length; j++) {
                numberArr[j] = number.charAt(j) - '0';
            }
            change = Integer.parseInt(st.nextToken());
            max = 0;

            // 교환 횟수가 자릿수보다 크다면 자릿수로 교환 횟수를 초기화
            // 자릿수만큼 있으면 어느 조합도 가능하기 때문에 시간 최적화
            if (numberArr.length < change) {
                change = numberArr.length;
            }

            dfs(0, 0);
            int idx = i + 1;
            System.out.println("#" + idx + " " + max);
            max = 0;
        }
    }
    public static void dfs(int number, int cnt) {
        if (cnt == change) {
            int res = 0;
            for (int i = 0; i < numberArr.length; i++) {
                res += Math.pow(10,i) * numberArr[numberArr.length - i - 1];
            }

            max = Math.max(res, max);

            return;
        }

        for (int i = 0; i < numberArr.length; i++) {
            for (int j = i+1; j < numberArr.length; j++) {
                swap(i,j);
                dfs(i, cnt + 1);
                swap(i,j);
            }
        }
    }

    public static void swap(int i, int j) {
        int temp = numberArr[i];
        numberArr[i] = numberArr[j];
        numberArr[j] = temp;
    }
}