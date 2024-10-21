import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static String S, T;
    static boolean flag = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        S = br.readLine();
        T = br.readLine();

        // 역방향 탐색 시작
        backtrack(T);

        // 최종 결과 출력
        if (flag) System.out.println(1);
        else System.out.println(0);
    }

    public static void backtrack(String current) {
        // 목표 문자열 S에 도달한 경우
        if (current.equals(S)) {
            flag = true;
            return;
        }

        // 현재 문자열의 길이가 S보다 작아지면 더 이상 진행할 필요가 없음
        if (current.length() < S.length()) return;

        // 마지막 문자가 'A'인 경우 마지막 문자 제거
        if (current.charAt(current.length() - 1) == 'A') {
            backtrack(current.substring(0, current.length() - 1));
        }

        // 첫 번째 문자가 'B'인 경우 뒤집고 첫 문자 제거
        if (current.charAt(0) == 'B') {
            String reversed = new StringBuilder(current).reverse().toString();
            backtrack(reversed.substring(0, reversed.length() - 1));
        }
    }
}
