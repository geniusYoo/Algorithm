import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static int[] board;
    static boolean[] visited, path;
    static List<Integer> res = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        board = new int[N + 1];
        path = new boolean[N + 1];
        visited = new boolean[N + 1];

        for (int i = 1; i <= N; i++) {
            board[i] = Integer.parseInt(br.readLine());
        }

        for (int i = 1; i <= N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(i, i);
                visited[i] = false;
            }
        }

        // 결과 정렬
        Collections.sort(res);
        System.out.println(res.size());
        for (int result : res) {
            System.out.println(result);
        }
    }

    public static void dfs(int start, int target) {
        int next = board[start];
        if (!visited[next]) {
            visited[next] = true;
            dfs(next, target);
            visited[next] = false;
        }
        if (board[start] == target) res.add(target);
    }
}
