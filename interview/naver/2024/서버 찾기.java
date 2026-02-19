/**
 * 서버 찾기 - 네이버 2024 신입 공채

여러 개의 서버와 참가자들별로 각 서버의 지연 시간을 나타내는 delays가 주어지고, 서버를 찾을 제한조건을 담은 limits가 주어질 때 해당 제한조건을 만족하는 서버들 중 가장 많은 참가자의 수와 서버 번호를 리턴하세요. 만약 해당하는 서버의 수가 여러개면 가장 빠른 서버 번호를 출력하세요.

delays 배열은 2차원 배열로 주어집니다. dalays.length는 참가자의 수 이며, delays[i]는 i번째 참가자의 서버별 delay가 배열로 주어집니다. delay[i].length는 서버의 수 이며, delays[i][j]는 i번째 참가자의 (j + 1)번째 서버에 해당하는 delay를 나타내고 단위는 ms입니다.
예를 들어 delays = [[2423, 10, 5], [3423, 30, 15]] 이라고 할 때, 참가자는 2명이고 서버는 3대입니다. 1번 참가자가 서버에 참가할 때 1번 서버는 2423ms, 2번 서버는 10ms, 3번 서버는 5ms의 delay가 발생함을 나타냅니다. 

limits는 2개의 원소가 주어지고 각각 아래의 조건을 나타냅니다.
limits[0]: 각 서버에서 모든 참가자들의 delay가 x배 이상 차이나지 않아야 함을 의미함
limits[1]: 각 서버에서 모든 참가자들의 delay가 x초 이상 차이나지 않아야 함을 의미함 (x초 = x,000ms)
최대 참가자 수를 구할 때 limits의 조건 두 가지를 모두 만족해야 합니다.

예제 1:
입력
delays = [[2423, 10], [3423, 30], [1, 40], [450, 50], [1200, 60], [2781, 100]]
limits = [2, 1]
출력: results = [3, 2]
설명:
6명의 참가자(delays.length)와 2개의 서버(delays[i].length)가 주어집니다. 각 서버의 최대 참가자 수를 구할 때, 참가자들간의 delay는 2배(limits[0]) 이상 차이나지 않아야하며 1,000ms(limits[1] * 1000) 이상 차이나지 않아야 합니다. 그렇다면 해당 조건을 만족하는 경우는
1번 서버: 최대 2명 (2423, 2781 혹은 3423, 2781)
2번 서버: 최대 3명 (30, 40, 50 혹은 40, 50, 60)
이므로 최대 참가 인원 3명인 2번 서버를 출력합니다. ([3, 2])

예제 2:
입력:
delays = [[10, 50000, 100], [1, 100000, 1100], [51, 100000, 2100], [90, 100000, 3100], [73, 50000, 4100]]
limits = [10, 4]
출력: results = [4, 1]
설명:
5명의 참가자(delays.length)와 3개의 서버(delays[i].length)가 주어집니다. 각 서버의 최대 참가자 수를 구할 때, 참가자들간의 delay는 10배(limits[0]) 이상 차이나지 않아야하며 4,000ms(limits[1] * 1000)이상 차이나지 않아야 합니다.
이 때 해당 조건을 만족하는 경우는
1번 서버: 최대 4명 (10, 51, 90, 73)
2번 서버: 최대 3명 (100000, 100000, 100000)
3번 서버: 최대 4명 (1100, 2100, 3100, 4100)
		이므로 최대 참가 인원은 4명이고 이 중 가장 빠른 서버 번호 1번을 출력합니다. ([4, 1])

참고 사항:
0 < delays.length < 50,000
0 < delays[i][j] < 1,000,000
delays[i][j]의 단위는 ms 입니다
limits[1]의 단위는 s 입니다

샘플 코드:
    public static void main(String[] args) {
        System.out.println(Arrays.toString(findServers(new int[][] {{2423, 10}, {3423, 30}, {1, 40}, {450, 50}, {1200, 60}, {2781, 100}}, new int[] {2, 1}))); // [3, 2]
        System.out.println(Arrays.toString(findServers(new int[][] {{10, 50000, 100}, {1, 100000, 1100}, {51, 100000, 2100}, {90, 100000, 3100}, {73, 50000, 4100}}, new int[] {10, 4}))); // [4, 1]
    }
   
    private static int[] findServers(int[][] delays, int[] limits) {
        int max = Integer.MIN_VALUE, server = -1;
       
        for (int i = 0; i < delays[0].length; i++) {
            List<Integer> list = new ArrayList<>();
           
            for (int j = 0; j < delays.length; j++) {
                list.add(delays[j][i]);
            }
            Collections.sort(list);
           
            int l = 0, r = 0;
            while (r < list.size()) {
                int cur = list.get(r++);
               
                while (list.get(l) * limits[0] <= cur
                        || cur - list.get(l) >= limits[1] * 1000) {
                    l++;
                }
               
                if (r - l > max) {
                    max = r - l;
                    server = i + 1;
                }
            }
        }
       
        return new int[] {max, server};
    }
 */

import java.util.Arrays;

class Solution {
    public int[] findServers(int[][] delays, int[] limits) {
        int maxParticipant = Integer.MIN_VALUE, maxServer = -1;
        int participant = delays.length, server = delays[0].length;
        limits[1] *= 1000;

        for (int i = 0; i < server; i++) {
            for (int j = 0; j < participant; j++) {
                int[] serverDelays = new int[participant];
                for (int k = 0; k < participant; k++) {
                    serverDelays[k] = delays[k][i];
                }
                Arrays.sort(serverDelays);
                
                int l = 0, r = 0;
                while (r < participant) {
                    int delay = serverDelays[r++];
                    while (l < r && 
                        (delay * limits[0] >= serverDelays[l] 
                        || delay - serverDelays[l] >= limits[1])) l++;
                    if (r - l > maxParticipant) {
                        maxParticipant = r - l;
                        maxServer = i + 1;
                    }
                }
            }
        }
        return new int[] {maxParticipant, maxServer};
    }
}