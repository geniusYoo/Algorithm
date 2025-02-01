import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static int[] target;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        String A = br.readLine();
        String B = br.readLine();
        int[] now = new int[N];
        target = new int[N];
        // 0 -> -1
        // 1
        Arrays.fill(now, 1);
        Arrays.fill(target, 1);
        for (int i = 0; i < N; i++) {
            if (A.charAt(i) == '0') now[i] = -1;
            if (B.charAt(i) == '0') target[i] = -1;
        }
        // 0번 스위치를 누르지 않았을 때
        int [] copyArr = new int[N];
        for (int i = 0; i < N; i++) {
            copyArr[i] = now[i];
        }
        int res1 = push(copyArr);
        // 0번 스위치를 눌렀을 때
        now[0] *= -1;
        now[1] *= -1;
        int res2 = push(now);
        if (res2 >= 0) res2++;

        // 둘다 0 이상이면 최소값
        if (res1 >= 0 && res2 >= 0) System.out.println(Math.min(res1, res2));
        // 둘 중 하나가 0 이상이면 출력
        else if (res1 < 0) System.out.println(res2);
        else if (res2 < 0) System.out.println(res1);
        else System.out.println(-1);
    }

    public static int push(int[] now) {
        int cnt = 0;

        for (int i = 1; i < N; i++) {
            // 0번 전구의 상태가 서로 다르면
            if (now[i-1] != target[i-1]) {
                now[i-1] *= -1;
                now[i] *= -1;
                if (i < N-1) now[i+1] *= -1;
                cnt++;
            }
        }

        for (int i = 0; i < N; i++) {
            if (now[i] != target[i]) cnt = -1;
        }
        return cnt;
    }
 }