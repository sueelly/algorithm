class Solution {
    int[][] matrix;
    int m;
    int n;

    public void setZeroes(int[][] matrix) {
        this.matrix = matrix;
        this.m = matrix.length;
        this.n = matrix[0].length;
        int i, j;
        boolean isFirstRowZero = false, isFirstColZero = false;

        for (j = 0; j < n; j++) {
            if (matrix[0][j] == 0) {
                isFirstRowZero = true;
                break ;
            }
        }
        for (i = 0; i < m; i++) {
            if (matrix[i][0] == 0) {
                isFirstColZero = true;
                break ;
            }
        }
        
        // 첫째 행/열을 제외하고, 0이 존재하는 행과 열은 그 가장 앞을 0으로 세팅 -> 첫째 행/열의 값은 세팅값으로 설정 (본래의 값과 구분)
        // 첫째 행/열은 함께 0으로 세팅 시 세팅된 값인지 본래의 값인지 구분이 불가 -> 위에서 따로 설정
        for (i = 1; i < m; i++) {
            for (j = 1; j < n; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        for (i = 1; i < m; i++) if (matrix[i][0] == 0) setZero(i, true);
        for (j = 1; j < n; j++) if (matrix[0][j] == 0) setZero(j, false);

        if (isFirstRowZero) setZero(0, true);
        if (isFirstColZero) setZero(0, false);
    }

    void setZero(int k, boolean isRow) {
        if (isRow) {
            for (int i = 0; i < n; i++) matrix[k][i] = 0;
        } else {
            for (int i = 0; i < m; i++) matrix[i][k] = 0;
        }
    }
}