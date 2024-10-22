import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int N, K;
    static int[] A;
    static boolean[] robot;
    static int zeroCnt = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        A = new int[N * 2];
        robot = new boolean[N];

        for (int i = 0; i < N * 2; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        int stage = 0;

        while (zeroCnt < K) {
            stage++;
            rotateBelt();
            moveRobot();
            placeRobot();
            int cnt = 0;
            for (int i = 0; i < N * 2; i++) {
                if (A[i] == 0) cnt++;
                zeroCnt = cnt;
            }
        }
        System.out.println(stage);
    }

    public static void rotateBelt() {
        int tmp = A[2 * N - 1];
        for (int i = 2 * N - 1; i > 0; i--) {
            A[i] = A[i-1];
        }
        A[0] = tmp;

        for (int i = N - 1; i > 0; i--) {
            robot[i] = robot[i-1];
        }
        robot[0] = false;
        robot[N - 1] = false;
    }

    public static void moveRobot() {
        for (int i = N - 2; i >= 0; i--) {
            if (robot[i] && !robot[i+1] && A[i+1] > 0) {
                robot[i+1] = true;
                robot[i] = false;
                A[i+1]--;
            }
        }
        robot[N-1] = false;
    }

    public static void placeRobot() {
        if (A[0] > 0) {
            robot[0] = true;
            A[0]--;
        }
    }
}
