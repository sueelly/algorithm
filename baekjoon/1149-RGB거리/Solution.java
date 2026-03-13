/**
 * 백준 1149번: RGB거리
 *
 * [문제 요약]
 * N개의 집이 일렬로 있고, 각 집을 빨강/초록/파랑 중 하나로 칠한다.
 * 인접한 집은 같은 색이 될 수 없을 때, 모든 집을 칠하는 최소 비용을 구한다.
 */
public class Solution {

    /**
     * 모든 집을 칠하는 최소 비용을 반환
     *
     * @param n     집의 수 (2 ≤ N ≤ 1,000)
     * @param costs costs[i][0..2] = i번째 집을 빨강, 초록, 파랑으로 칠하는 비용
     * @return 최소 비용
     */
    public int solve(int n, int[][] costs) {
        int[][] dp = new int[n][3]; // i번째 집이 R G B일 때의 최솟값

        dp[0][0] = costs[0][0];
        dp[0][1] = costs[0][1];
        dp[0][2] = costs[0][2];
        for (int i = 1; i < n; i++) {
            dp[i][0] = costs[i][0] + Math.min(dp[i - 1][1], dp[i - 1][2]);
            dp[i][1] = costs[i][1] + Math.min(dp[i - 1][0], dp[i - 1][2]);
            dp[i][2] = costs[i][2] + Math.min(dp[i - 1][0], dp[i - 1][1]);
        }
        if (dp[n - 1][0] <= dp[n - 1][1] && dp[n - 1][0] <= dp[n - 1][2]) return dp[n - 1][0];
        if (dp[n - 1][1] <= dp[n - 1][0] && dp[n - 1][1] <= dp[n - 1][2]) return dp[n - 1][1];
        return dp[n - 1][2];
    }
}
