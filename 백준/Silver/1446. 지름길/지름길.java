import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Road {
    int start;
    int end;
    int len;
    public Road(int start, int end, int len) {
        this.start = start;
        this.end = end;
        this.len = len;
    }
}
class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());
        ArrayList<Road> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int val = Integer.parseInt(st.nextToken());
            if ((end - start) > val && end <= D) list.add(new Road(start, end, val));
        }

        int[] dist = new int[D + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0] = 0;

        for (int i = 0; i <= D; i++) {
            if (i > 0) dist[i] = Math.min(dist[i], dist[i-1] + 1);

            for (Road r : list) {
                if (r.start == i) { // 지름길 시작
                    dist[r.end] = Math.min(dist[r.end], dist[i] + r.len);
                }
            }
        }

        System.out.println(dist[D]);
    }

}