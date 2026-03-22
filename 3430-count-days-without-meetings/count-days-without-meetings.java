class Solution {
    public int countDays(int days, int[][] meetings) {
        int n = meetings.length, count = 0, last = 1;

        Arrays.sort(meetings, (m1, m2) -> {
            if (m1[0] == m2[0]) return m1[1] - m2[1];
            return m1[0] - m2[0]; 
        });
        for (int i = 0; i < n; i++) {
            if (i < n - 1 && meetings[i][0] == meetings[i + 1][0]) continue ;
            if (meetings[i][1] < last) continue ;
            count += Math.max(meetings[i][0] - last, 0);
            last = meetings[i][1] + 1;
        }
        count += days - last + 1;
        return count;
    }
}