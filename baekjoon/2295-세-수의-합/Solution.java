import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 백준 2295번: 세 수의 합
 * 
 * [문제 요약]
 * N개의 자연수 집합 U에서 세 수 a, b, c를 골라
 * a + b + c = d (d도 U에 포함)를 만족하는 가장 큰 d를 구하기
 * 같은 수를 여러 번 골라도 됨
 */
public class Solution {

    /**
     * 세 수의 합이 집합 내에 존재하는 경우 중 최대 d를 반환
     * 
     * @param n 집합의 크기 (5 ≤ n ≤ 1,000)
     * @param u 집합의 원소들 (자연수, ≤ 200,000,000)
     * @return 가장 큰 d (a + b + c = d, a, b, c, d ∈ U)
    */
    public int solve(int n, int[] u) {
        Arrays.sort(u);
        Set<Integer> aPlusB = new HashSet<>();

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                aPlusB.add(u[i] + u[j]);
            }
        }

        for (int i = n - 1; i > 0; i--) {
            for (int j = i - 1; j >= 0; j--) {
                if (aPlusB.contains(u[i] - u[j])) return u[i];
            }
        }
        return 0;
    }
}
