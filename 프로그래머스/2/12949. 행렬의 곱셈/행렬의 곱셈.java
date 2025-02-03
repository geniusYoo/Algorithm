class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int r1 = arr1.length;
        int c1 = arr1[0].length;
        int r2 = arr2.length;
        int c2 = arr2[0].length;
        
        int[][] ans = new int[r1][c2];
        for (int i=0; i<arr1.length; i++) {
            for (int j=0; j<arr2[0].length; j++) {
                for (int k=0; k<arr2.length; k++) {
                ans[i][j] += arr1[i][k] * arr2[k][j];
                }
            }
        }
        return ans;
    }
}