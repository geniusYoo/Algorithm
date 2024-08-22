
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());

        System.out.println(A * B / gcd(A,B));
    }

    public static long gcd(long a, long b) {
        while (b != 0) {
            int r = (int) (a % b);
            a = b;
            b = r;
        }
        return a;
    }
}


