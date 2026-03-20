class Solution {
    int m;
    int n;
    char[][] matrix;

    public int maximalRectangle(char[][] matrix) {
        m = matrix.length;
        n = matrix[0].length;
        this.matrix = matrix;
        int max = 0;
        int[][] area = new int[m][n];

        // 각 시작점에서의 최대 사각형 너비 저장 -> 시작점 판단 기준: 왼&위가 0/막힘
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // if ((j == 0 || matrix[i][j - 1] == '0') && (i == 0 || matrix[i - 1][j] == '0')) area[i][j] = getArea(i, j);
                area[i][j] = getArea(i, j);
                if (max < area[i][j]) max =area[i][j]; 
            }
        }
        return max;
    }

    int getArea(int row, int col) {
        int width = 0, length = 1, max;
        int i, j, tmp;

        for (i = col; i < n && matrix[row][i] == '1'; i++) width++;
        max = width;

        for (i = row + 1; i < m && matrix[i][col] == '1'; i++) {
            length++;
            tmp = 0;
            for (j = col; j < n && tmp < width && matrix[i][j] == '1'; j++) tmp++;
            if (tmp < width) width = tmp;
            if (width * length > max) max = width * length;
        }
        // System.out.println(row + " " + col + ": " + max);
        return max;
    }

    void print(int[][][] dp) {
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                System.out.print(dp[i][j][0] + " " + dp[i][j][1] + ", ");
            }
            System.out.println();
        }
    }
}