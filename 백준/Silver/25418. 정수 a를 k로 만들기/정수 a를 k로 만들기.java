import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int res = 0;


        // A -> K
        while (K - A >= A) {
            if (K % 2 != 0) { // 홀수이면 -1
                K--;
                res++;
            }
            else {
                K /= 2;
                res++;
            }
        }
        res += (K - A) % A;
        System.out.println(res);
    }
}