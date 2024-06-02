import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int cnt = Integer.parseInt(br.readLine());
        String [][] arr = new String [cnt][2];
        HashMap<String, List<String>> map = new HashMap<>();
        for (int i = 0; i < cnt; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = st.nextToken();
            arr[i][1] = st.nextToken();
        }


        for (int i = 0; i < cnt; i++) {
            if (!map.containsKey(arr[i][0])){
                List<String> list = new ArrayList<>();
                list.add(arr[i][1]);
                map.put(arr[i][0], list);
            }
            else {
                List<String> list = map.get(arr[i][0]);
                list.add(arr[i][1]);
                map.put(arr[i][0], list);
            }
        }

        List<String> keys = new ArrayList<>();
        for (String key : map.keySet()) {
            keys.add(key);
        }
        Collections.sort(keys);

        for (String key : keys) {
            List<String> l = map.get(key);
            Collections.sort(l, Collections.reverseOrder());
            for (int i = 0; i < l.size(); i++) {
                System.out.print(key + " ");
                System.out.println(l.get(i));
            }
        }




    }


}
