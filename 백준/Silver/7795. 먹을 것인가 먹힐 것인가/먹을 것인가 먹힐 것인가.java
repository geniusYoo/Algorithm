import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int tc = Integer.parseInt(br.readLine());
        for (int i = 0; i < tc; i++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            int[] A = new int[N];
            int[] B = new int[M];

            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                A[j] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(A);
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                B[j] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(B);
            excute(A, B);
        }
    }
    public static void excute(int [] A, int [] B) {
        int res = 0;
        for (int i = 0; i < A.length; i++) { // A를 기준으로 Loop
            int start = 0; // B의 첫번째 인덱스
            int end = B.length - 1; // B의 마지막 인덱스
            int idx = 0;

            while (start <= end) {
                int mid = (start + end) / 2;
                if (B[mid] < A[i]) {
                    start = idx = mid + 1;
                }
                else {
                    end = mid - 1;
                }
            }
            res += idx;
        }
        System.out.println(res);
        
    }

}
