class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length, n = grid[0].length;

        for (int i = 0; i < m; i++) {
            if (i > 0) grid[i][0] += grid[i - 1][0];
            for (int j = 1; j < n; j++) {
                if (i > 0) grid[i][j] += Math.min(grid[i - 1][j], grid[i][j - 1]);
                else grid[i][j] += grid[i][j - 1];
            }
        }
        return grid[m - 1][n - 1];
    }
}