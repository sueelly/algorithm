// 코딩테스트 연습 - 2025 카카오 하반기 2차 - 힌트 스테이지: https://school.programmers.co.kr/learn/courses/30/lessons/468377
import java.util.Arrays;

class Solution {
    public int solution(int[][] cost, int[][] hint) {
        int answer = Integer.MAX_VALUE;
        int n = cost.length, k = hint[0].length - 1;
        int purchases, i, j, totalCost = 0;
        int[] hintCount = new int[n]; // stage i에서의 힌트권 개수: hintCount[i - 1];
        
        // (1 << i) & purchases값이 0이면 i stage에서 힌트권 비구매, 1이면 구매
        for (purchases = 0; purchases < (1 << (n - 1)); purchases++) { // 총 2^(n - 1)번 수행
            // purchases에 따라 stage별 힌트번들 구매
            for (i = 0; i < n; i++) {
                // 스테이지 해결 비용
                if (i == 0) totalCost += cost[i][0];
                else if (hintCount[i] >= n) totalCost += cost[i][n - 1]; 
                else totalCost += cost[i][hintCount[i]];
                
                if (((1 << i) & purchases) == 0 || i == n - 1) continue ;
                totalCost += hint[i][0]; // 힌트 번들 구매 비용
                for (j = 1; j <= k; j++) hintCount[hint[i][j] - 1]++;
            }
            
            // answer 업데이트
            if (answer > totalCost) answer = totalCost;
            
            // 초기화
            totalCost = 0;
            Arrays.fill(hintCount, 0);
        }
        return answer;
    }
}