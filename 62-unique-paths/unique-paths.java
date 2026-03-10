class Solution {
    public int uniquePaths(int m, int n) {
        long count = 1;
        int min = m > n ? n - 1 : m - 1;
        int all = m + n - 2;

        for (int i = 1; i <= min; i++) {
            count = count * all-- / i;
        }
        return (int) count; 
    }
}