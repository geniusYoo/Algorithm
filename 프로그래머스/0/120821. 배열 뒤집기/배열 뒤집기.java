class Solution {
    public int[] solution(int[] num_list) {
        int left = 0;
        int right = num_list.length - 1;
        while (left < right) {
            int tmp = num_list[left];
            num_list[left] = num_list[right];
            num_list[right] = tmp;
            left++;
            right--;
        }
        return num_list;
    }
}