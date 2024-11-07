import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Number {
    int floor;
    boolean[] led;
    public Number (int floor, boolean[] led) {
        this.floor = floor;
        this.led = led;
    }
}

public class Main {
    static Number[] numbers = new Number[10];
    static HashSet<Integer> result = new HashSet<>();
    static int finalRes = 0;
    static int P;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());
        setFloors();
        for (int i = 1; i <= N; i++) {
            if (i == X) continue;
            String target = String.valueOf(i);
            int targetLength = target.length();
            String now = String.valueOf(X);
            int nowLength = now.length();

            StringBuilder targetSb = new StringBuilder();
            StringBuilder nowSb = new StringBuilder();
            if (targetLength < K) {
                for (int j = 0; j < Math.abs(K-targetLength); j++) {
                    targetSb.append(0);
                }
            }
            if (nowLength < K) {
                for (int j = 0; j < Math.abs(K-nowLength); j++) {
                    nowSb.append(0);
                }
            }
            targetSb.append(target);
            nowSb.append(now);

            change(nowSb.toString(), targetSb.toString());
        }
        System.out.println(result.size());
    }

    public static void change(String now, String target) {
        int len = now.length();
        int res = 0;
        for (int i = 0; i < len; i++) {
            res += diff(String.valueOf(now.charAt(i)), String.valueOf(target.charAt(i)));
        }
        if (res <= P) result.add(Integer.parseInt(target));
    }

    public static int diff(String now, String target) {
        int n = Integer.parseInt(now);
        int t = Integer.parseInt(target);
        int res = 0;
        for (int i = 0; i < 7; i++) {
            if (numbers[n].led[i] != numbers[t].led[i]) res++;
        }
        return res;
    }

    public static void setFloors() {
        //                                             0     1     2     3     4      5     6
        numbers[0] = new Number(0, new boolean[]{true, true, true, false, true, true, true});
        numbers[1] = new Number(1, new boolean[]{false, false, true, false, false, true, false});
        numbers[2] = new Number(2, new boolean[]{true, false, true, true, true, false, true});
        numbers[3] = new Number(3, new boolean[]{true, false, true, true, false, true, true});
        numbers[4] = new Number(4, new boolean[]{false, true, true, true, false, true, false});
        numbers[5] = new Number(5, new boolean[]{true, true, false, true, false, true, true});
        numbers[6] = new Number(6, new boolean[]{true, true, false, true, true, true, true});
        numbers[7] = new Number(7, new boolean[]{true, false, true, false, false, true, false});
        numbers[8] = new Number(8, new boolean[]{true, true, true, true, true, true, true});
        numbers[9] = new Number(9, new boolean[]{true, true, true, true, false, true, true});

        
    }
}
