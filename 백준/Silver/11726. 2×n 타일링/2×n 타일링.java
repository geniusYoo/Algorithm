import org.w3c.dom.Node;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());

        int [] tile = new int [N+2];
        tile[1] = 1;
        tile[2] = 2;

        for (int i = 3; i <= N; i++) {
            tile[i] = tile[i-2] + tile[i-1];
            tile[i] %= 10_007;
        }
        System.out.println(tile[N]);
    }
}