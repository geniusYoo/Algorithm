import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());
        int[][] map = new int[H][W];
        ArrayList<Integer>[] mapList = new ArrayList[H];
        for (int i = 0; i < H; i++) {
            mapList[i] = new ArrayList<>();
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < W; i++) {
            int block = Integer.parseInt(st.nextToken());
            for (int j = 0; j < block; j++) {
                map[H-j-1][i] = -1;
            }
        }

        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                if (map[i][j] == -1) mapList[i].add(j);
            }
        }

        int res = 0;
        for (int i = 0; i < H; i++) {
            if (mapList[i].size() > 1) {
                int left = 0;
                int right = 1;
                while (right != mapList[i].size()) {
                    res += mapList[i].get(right) - mapList[i].get(left) - 1;
                    left++;
                    right++;
                }
            }
        }

        System.out.println(res);
    }
}
