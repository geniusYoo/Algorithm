import org.w3c.dom.Node;

import java.io.*;
import java.util.*;

class Main {
    static int computer_cnt, pair_cnt, res;
    static boolean[] visited;
    static int[][] adj;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        computer_cnt = Integer.parseInt(br.readLine());
        pair_cnt = Integer.parseInt(br.readLine());
        StringTokenizer st;
        visited = new boolean[computer_cnt+1];
        adj = new int[computer_cnt+1][computer_cnt+1];

        for (int i = 0; i < pair_cnt; i++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            adj[N][M] = adj[M][N] = 1;
        }

        visited[1] = true;
        dfs(1);
        System.out.println(res);
    }
    public static void dfs(int now) {
        for (int i = 1; i <= computer_cnt; i++) {
            if (!visited[i] && adj[now][i] == 1) {
                visited[i] = true;
                res++;
                dfs(i);
            }
        }
    }
}


