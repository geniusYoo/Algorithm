import org.w3c.dom.Node;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;



class Main {
    private static int [][] weight;
    private static boolean [] visited;
    private static int M, N;
    private static List<Integer> res = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        weight = new int[N+1][N+1];
        for (int i = 0; i < N-1; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            weight[x][y] = weight[y][x] = w;
        }


        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            visited = new boolean[N+1];
            visited[x] = true;
            dfs(x,y,0);
            System.out.println(res.get(i));
        }
    }

    public static void dfs(int s, int e, int cnt) {
        if (s == e) {
            res.add(cnt);
            return;
        }

        for (int i = 0; i < weight[s].length; i++) {
            if (weight[s][i] == 0) continue;

            if (!visited[i]) {
                visited[i] = true;
                dfs(i, e, cnt + weight[s][i]);
                visited[i] = false;
            }
        }
    }



}