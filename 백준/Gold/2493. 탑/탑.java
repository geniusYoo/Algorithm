import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

class Tower {
    int num;
    long height;

    public Tower(int num, long height) {
        this.num = num;
        this.height = height;
    }
}
class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        long [] arr = new long [N+1];
        long [] res = new long[N+1];
        Stack<Tower> stack = new Stack<>();

        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = N; i > 0; i--) {
            Tower now = new Tower(i, arr[i]);
            while (!stack.isEmpty() && stack.peek().height < now.height) {
                res[stack.peek().num] = now.num;
                stack.pop();
            }
            stack.push(now);
        }

        for (int i = 1; i <= N; i++) {
            System.out.print(res[i] + " ");
        }


    }
}