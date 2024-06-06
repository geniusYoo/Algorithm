import com.sun.source.tree.Tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        HashMap<String, List<String>> group = new HashMap<>();
        HashMap<String, String> map = new HashMap<>();
        for (int i = 0; i < N; i++) {
            String girlGrp = br.readLine();
            List<String> temp = new ArrayList<>();
            int cnt = Integer.parseInt(br.readLine());
            for (int j = 0; j < cnt; j++) {
                String girl = br.readLine();
                temp.add(girl);
                map.put(girl, girlGrp);
            }
            group.put(girlGrp, temp);
        }

        for (int i = 0; i < M; i++) {
            String quest = br.readLine();
            int num = Integer.parseInt(br.readLine());

            if (num == 0) {
                List<String> answer = group.get(quest);
                Collections.sort(answer);
                for (String girls : answer) {
                    System.out.println(girls);
                }
            }

            else {
                System.out.println(map.get(quest));
            }
        }
    }


}
