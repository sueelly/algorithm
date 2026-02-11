/**
 * 백준 3273번: 두 수의 합
 * 
 * [문제 요약]
 * n개의 서로 다른 양의 정수로 이루어진 수열에서
 * 두 수의 합이 x가 되는 쌍의 개수를 구하기
 * 
 * [힌트]
 * - 정렬 후 투 포인터 사용: O(n log n)
 * - HashSet/boolean 배열 활용: O(n)
 */
public class Solution {
    
    /**
     * 두 수의 합이 x가 되는 쌍의 개수 계산
     * 
     * @param n 수열의 크기 (1 ≤ n ≤ 100,000)
     * @param arr 수열 (서로 다른 양의 정수, 1 ≤ arr[i] ≤ 1,000,000)
     * @param x 목표 합 (1 ≤ x ≤ 2,000,000)
     * @return ai + aj = x를 만족하는 (ai, aj) 쌍의 수 (i < j)
     */
    public int solve(int n, int[] arr, int x) {
        boolean[] occur = new boolean[x]; // 겹치는 수가 없으므로 boolean 배열 사용
        int result = 0;

        for (int i = 0; i < n; i++) {
            if (arr[i] >= x) continue ;
            if (occur[x - arr[i]]) result++;
            occur[arr[i]] = true;
        }
        return result;
    }
}
