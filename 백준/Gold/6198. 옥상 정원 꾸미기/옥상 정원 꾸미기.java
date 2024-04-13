import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;

class Main {
    private static final int [] rx = {-1, 0, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Stack<Integer> tower = new Stack<>();

        long result = 0;
        for (int i = 0; i < N; i++) {
            int height = Integer.parseInt(br.readLine());
            while(!tower.isEmpty() && tower.peek() <= height) {
                tower.pop();
            }
            tower.push(height);
            result += tower.size() - 1;
        }

        System.out.println(result);

    }
}