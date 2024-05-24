import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {

    public static class Student {
        int sex; // 남자 1, 여자 2
        int num;

        public Student(int sex, int num) {
            this.sex = sex;
            this.num = num;
        }
    }

    public static int [] switches;
    public static int [] idx;
    public static List<Student> students = new ArrayList<>();
    public static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int switchCnt = Integer.parseInt(br.readLine());
        switches = new int [switchCnt+1];
        idx = new int [switchCnt+1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= switchCnt; i++) {
            switches[i] = Integer.parseInt(st.nextToken());
        }

        int studentCnt = Integer.parseInt(br.readLine());
        for (int i = 0; i < studentCnt; i++) {
            st = new StringTokenizer(br.readLine());
            students.add(new Student(Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken())));

        }

        for (Student s : students) {
            if (s.sex == 1) { // 남자면
                for (int i = s.num; i <= switchCnt ; i++) {
                    if (i % s.num == 0) {
                        toggle(i);
                    }
                }
            }
            else { // 여자
                toggle(s.num);
                int ascIdx = s.num + 1;
                int descIdx = s.num - 1;

                while (ascIdx <= switchCnt && descIdx > 0) {
                    if (switches[ascIdx] == switches[descIdx]) {
                        toggle(ascIdx);
                        toggle(descIdx);
                    }
                    else {
                        break;
                    }
                    ascIdx++;
                    descIdx--;
                }
            }
        }

        int c = 0;
        for (int i = 1; i <= switchCnt; i++) {
            if (c == 20) {
                System.out.println();
                c = 0;
            }
            System.out.print(switches[i] + " ");
            c++;
        }

    }
    public static void toggle(int idx) {
        switches[idx] = switches[idx] == 0 ? 1 : 0;
    }

}
