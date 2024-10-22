import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int H = Integer.parseInt(st.nextToken());
            int W = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());

            int x = N / H;
            int y = N % H;

            if (y > 0) x++;
            if (y == 0) y = H;

            StringBuilder sb = new StringBuilder();
            sb.append(y);
            if (x < 10) sb.append(0);
            sb.append(x);
            System.out.println(sb);
        }


    }
}
