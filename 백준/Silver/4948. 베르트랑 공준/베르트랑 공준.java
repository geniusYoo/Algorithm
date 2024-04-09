import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
    public static void main(String[] args) throws IOException {
        int N = 123456;
        boolean [] prime = new boolean[(N * 2) + 1]; // 소수 배열

        prime[0] = true;
        prime[1] = true;

        for (int i = 2; i <= Math.sqrt(prime.length) ; i++) {
            if (!prime[i]) { // 확인하지 않은 변수
                for (int j = i*i; j < prime.length ; j+=i) {
                    // i의 제곱부터 i의 배수들을 지워나감
                    prime[j] = true;
                }
            }
        }

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true) {
            int target = Integer.parseInt(br.readLine());
            if (target == 0) break;

            int result = 0;
            for (int i = target+1; i <= target * 2; i++) {
                if (!prime[i]) {
                    result++;
                }
            }
            System.out.println(result);

        }
    }
}