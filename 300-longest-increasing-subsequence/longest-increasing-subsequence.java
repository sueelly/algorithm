class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length, i, j, tmp, max = 1;
        int[] dp = new int[n];

        dp[0] = 1;
        for (i = 1; i < n; i++) {
            dp[i] = 1;
            for (j = i - 1; j >= 0; j--) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                } else if (nums[i] == nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j]);
                    break ;
                }
            }
            if (max < dp[i]) max = dp[i];
        }
        // print(dp);
        return max;
    }

    void print(int[] arr) {
        for (int i = 0; i < arr.length; i++) System.out.print(arr[i] + " ");
        System.out.println();
    }
}