import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[8];
        int[] umm = new int[3];
        for (int i = 0; i < 8; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < 7; i++) {
            if (arr[i] < arr[i+1]) umm[0]++;
            if (arr[i] > arr[i+1]) umm[1]++;
        }
        if (umm[0] == 7) System.out.println("ascending");
        else if (umm[1] == 7) System.out.println("descending");
        else System.out.println("mixed");

    }
}
