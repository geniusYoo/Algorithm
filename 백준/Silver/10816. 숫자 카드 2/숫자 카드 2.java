import org.w3c.dom.Node;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;


class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        HashMap<Integer, Integer> card = new HashMap<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int c = Integer.parseInt(st.nextToken());
            if (card.get(c) == null) card.put(c, 1);
            else {
                int pre = card.get(c);
                pre++;
                card.put(c, pre);
            }
        }

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int [] target = new int [M];
        for (int i = 0; i < M; i++) {
            target[i] = Integer.parseInt(st.nextToken());
        }

        StringBuilder sb = new StringBuilder();
        for (int i=0; i<M; i++) {
            if (card.get(target[i]) == null) sb.append(0).append(" ");
            else sb.append(card.get(target[i])).append(" ");
        }

        System.out.println(sb);
    }
}