class Solution {
    public int uniquePaths(int m, int n) {
        long count = 1;
        int min = Math.min(m - 1, n - 1);
        int all = m + n - 2;

        for (int i = 1; i <= min; i++) {
            count = count * all-- / i;
        }
        return (int) count; 
    }
}