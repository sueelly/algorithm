class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid[0][0] == 1) return 0;

        int i, j, m = obstacleGrid.length, n = obstacleGrid[0].length;

        for (i = 0; i < n && obstacleGrid[0][i] != 1; i++) obstacleGrid[0][i] = 1;
        for (; i < n; i++) obstacleGrid[0][i] = 0;
        for (i = 1; i < m && obstacleGrid[i][0] != 1; i++) obstacleGrid[i][0] = 1;
        for (; i < m; i++) obstacleGrid[i][0] = 0;

        for (i = 1; i < m; i++) {
            for (j = 1; j < n; j++) {
                if (obstacleGrid[i][j] == 1) obstacleGrid[i][j] = 0;
                else obstacleGrid[i][j] = obstacleGrid[i - 1][j] + obstacleGrid[i][j - 1];
            }
        }
        // print(obstacleGrid);
        return obstacleGrid[m - 1][n - 1];
    }

    // void print(int[][] grid) {
    //     for (int i = 0; i < grid.length; i++) {
    //         for (int j = 0; j < grid[0].length; j++) System.out.print(grid[i][j] + " ");
    //         System.out.println();
    //     }
    // }
}