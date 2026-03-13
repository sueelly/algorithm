/**
 * 백준 1074번: Z
 *
 * [문제 요약]
 * 2^N × 2^N 배열을 Z순서로 방문할 때, (r, c)가 몇 번째로 방문되는지 구한다.
 */
public class Solution {

    /**
     * (r, c)의 방문 순서(0-based)를 반환
     *
     * @param n 1 ≤ N ≤ 15
     * @param r 행 (0 ≤ r < 2^N)
     * @param c 열 (0 ≤ c < 2^N)
     * @return 방문 순서
     */
    public int solve(int n, int r, int c) {
        int answer = 0;
        n = (int) Math.pow(2, n);

        while (n != 1) {
            n >>= 1;

            if (r >= n) {
                answer += 2 * n * n;
                r -= n;
            }
            if (c >= n) {
                c -= n;
                answer += n * n;
            }
        }
        return answer;
    }
}
