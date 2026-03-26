class Solution {
    int[] nums;
    int n;
    int target;

    public int findTargetSumWays(int[] nums, int target) {
        this.nums = nums;
        n = nums.length;
        int sum = 0;
        
        for (int i = 0; i < n; i++) sum += nums[i];
        if ((sum - target) % 2 != 0) return 0;
        this.target = (sum - target) / 2;

        return solve(0, 0);
    }

    int solve(int i, int sum) {
        if (i == n) {
            if (sum == target) return 1;
            else return 0;
        }
        if (sum > target) return 0;
        return solve(i + 1, sum + nums[i]) + solve(i + 1, sum);
    }
}