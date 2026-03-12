/**
    try 1. '탐색해야 하는' 값은 건드릴 수 없지만, '탐색 완료'된 값은 변경 가능
     => (row, col)에 '와야하는 값'을 찾아 저장 <- ((n - 1 - col) % n, row)

    try 2. 하나의 숫자는 다른 3개의 숫자에 연쇄적으로 영향을 준다
     =>  4개를 한 묶음으로 바꾸기 && 사등분하여 왼쪽 위 사각형만 탐색
 */

class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        int tmp;

        for (int i = 0; i < n / 2; i++) {
            for (int j = 0; j < n / 2 + n % 2; j++){
                tmp = matrix[i][j];
                matrix[i][j] = matrix[(n - 1 - j) % n][i];
                matrix[(n - 1 - j) % n][i] = matrix[(n - 1 - i) % n][(n - 1 - j) % n];
                matrix[(n - 1 - i) % n][(n - 1 - j) % n] = matrix[j][(n - 1 - i) % n];
                matrix[j][(n - 1 - i) % n] = tmp;
            }
        }
    }
}