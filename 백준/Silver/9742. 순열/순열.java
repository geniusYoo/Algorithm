import org.w3c.dom.Node;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    public static String MSG;
    public static int LOCATION;
    public static char [] arr, answer;
    public static boolean [] used;
    public static String res;
    public static int cnt;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        String reader = "";
        while ((reader = br.readLine()) != null) {
            st = new StringTokenizer(reader, " ");
            if (!st.hasMoreTokens()) {
                return;
            }
            MSG = st.nextToken();
            LOCATION = Integer.parseInt(st.nextToken());
            arr = new char[MSG.length()];
            answer = new char[MSG.length()];
            used = new boolean[MSG.length()];
            arr = MSG.toCharArray();
            cnt = 0;
            backtrack(0);
            if (LOCATION > cnt) System.out.println(MSG + " " + LOCATION + " = No permutation");

        }

    }

    public static void backtrack(int idx) {
        if (idx == MSG.length()) {
            cnt++;
            if (cnt == LOCATION) {
                System.out.println(MSG + " " + LOCATION + " = " + String.valueOf(answer));
            }
            return;
        }
        for (int i = 0; i < MSG.length(); i++) {
            if (!used[i]) {
                used[i] = true;
                answer[idx] = arr[i];
                backtrack(idx + 1);
                used[i] = false;
            }
        }
    }
}
