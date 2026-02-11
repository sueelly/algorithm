/**
 * 백준 1475번: 방 번호
 * 
 * 0-9 숫자판 세트를 이용해 방 번호를 만들 때 필요한 최소 세트 개수
 * 단, 6과 9는 서로 뒤집어서 사용 가능
 */
public class Solution {

    /**
     * 필요한 세트 개수 계산
     * 
     * @param n 방 번호 (1 ~ 1,000,000)
     * @return 필요한 최소 세트 개수
     */
    public int solve(int n) {
        int[] numberCounts = new int[9];
        int max = 0;

        while (n > 0) {
            if (n % 10 == 9) numberCounts[6]++;
            else numberCounts[n % 10]++;
            n /= 10;
        }
        numberCounts[6] = numberCounts[6] / 2 + (numberCounts[6] & 1);
        for (int i = 0; i < 9; i++) {
            if (numberCounts[i] > max) max = numberCounts[i];
        }
        return max;
    }
}
