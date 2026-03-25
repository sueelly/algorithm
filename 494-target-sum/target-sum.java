class Solution {
    int[] nums;
    int n;
    int target;

    public int findTargetSumWays(int[] nums, int target) {
        this.nums = nums;
        n = nums.length;
        this.target = target;

        return solve(0, 0);
    }

    int solve(int i, int sum) {
        if (i == n) {
            if (sum == target) return 1;
            else return 0;
        }
        
        return solve(i + 1, sum + nums[i]) + solve(i + 1, sum - nums[i]);
    }
}