class Solution {
    public long countCompleteDayPairs(int[] hours) {
        int n = hours.length;
        int[] count = new int[24];
        long result = 0;
        
        // modulo every elements of hours by 24. cf) (a + b) % 24 = (a % 24 + b % 24) % 24
        for (int i = 0; i < n; i++) {
            hours[i] = hours[i] % 24;
            count[hours[i]]++;
        }

        // Count when sum is 0 or 24
        if (count[0] > 1) result = (long) count[0] * (count[0] - 1) / 2;
        if (count[12] > 1) result += (long) count[12] * (count[12] - 1) / 2;

        int left = 1, right = 23;
        while (left < right) {
            result += (long) count[left] * count[right];
            left++;
            right--;
        }
        return result;
    }
}