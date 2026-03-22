class Solution {
    public int countDays(int days, int[][] meetings) {
        int n = meetings.length, count = 0, last = 1;

        Arrays.sort(meetings, (m1, m2) -> {
            if (m1[0] == m2[0]) return m1[1] - m2[1];
            return m1[0] - m2[0]; 
        });
        for (int i = 0; i < n; i++) {
            while (last < meetings[i][0]) {
                count++;
                last++;
            }
            last = Math.max(last, meetings[i][1] + 1);
        }
        while (last++ <= days) count++;
        return count;
    }
}