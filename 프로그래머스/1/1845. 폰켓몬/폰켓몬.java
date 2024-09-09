import java.util.HashSet;
class Solution {
 public int solution(int[] nums) {
        int cnt = nums.length / 2; // 내가 고를 수 있는 포켓몬 개수
        HashSet<Integer> hash = new HashSet<>();
        for (int n : nums) {
            hash.add(n);
        }
        int res = hash.size(); // 서로 다른 포켓몬 개수
        int answer = cnt >= res ? res : cnt;
        return answer;
    }
}