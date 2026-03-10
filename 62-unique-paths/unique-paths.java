// Overflow when using multiplication -> Pascal's Triangle
// n multiplications vs 2 * n * n additions with O(n^2) space
class Solution {
    public int uniquePaths(int m, int n) {
        if (m == 1 || n == 1) return 1;
        int r = Math.min(m - 1, n - 1);
        n = m + n - 2;
        int[][] pascal = new int[n][r + 1];

        pascal[0][0] = 1;
        pascal[0][1] = 1;
        for (int i = 1; i < n; i++) {
            pascal[i][0] = 1;
            for (int j = 1; j <= r; j++) {
                pascal[i][j] = pascal[i - 1][j - 1] + pascal[i - 1][j];
            }
        }
        return pascal[n - 1][r];
    }
}