/**
 * 백준 1463번: 1로 만들기
 *
 * [문제 요약]
 * 정수 N이 주어졌을 때, 아래 세 연산을 적절히 사용하여
 * 1로 만드는 최소 연산 횟수를 구한다.
 *   1) X가 3으로 나누어 떨어지면 3으로 나눈다.
 *   2) X가 2로 나누어 떨어지면 2로 나눈다.
 *   3) 1을 뺀다.
 */
public class Solution {

    /**
     * N을 1로 만드는 최소 연산 횟수를 반환
     *
     * @param n 1 이상 10^6 이하의 정수
     * @return 최소 연산 횟수
     */
    public int solve(int n) {
        if (n == 1) return 0;
        int[] dp = new int[n + 1];

        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1];
            if (i % 3 == 0 && dp[i / 3] < dp[i]) dp[i] = dp[i / 3];
            if ((i & 1) == 0 && dp[i >> 1] < dp[i]) dp[i] = dp[i >> 1];
            dp[i]++;
        }
        return dp[n];
    }
}
