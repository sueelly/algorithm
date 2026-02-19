/**
 * 점수 옮기기 - 네이버 2024 신입 공채

나를 포함해 총 n + 1명의 참가자가 있는 대회가 있습니다. 대회는 예선과 본선 두 부분으로 구성되어 있으며 예선에서는 0점부터 최대 점수(cap)까지 점수를 얻을 수 있습니다.

예선에서 높은 점수를 받은 사람부터 순서대로 등수가 매겨지고, 상위 m등까지는 본선에 진출할 수 있습니다. 같은 점수를 받은 경우에는 동일한 등수를 받게 됩니다.

나의 등수는 나보다 높은 사람의 수에 1을 더한 값으로 정해집니다.

나는 본선에 진출하고 싶기 때문에 다른 참가자 두 명의 점수를 조작하여 내 등수를 높이려고 합니다.

점수 조작은 다음과 같은 방법으로 이루어집니다.
내가 선택한 다른 두 명의 참가자 중 한 명의 점수를 1점 낮추고 다른 한 명의 점수를 1점 높인다

내가 본선에 진출할 수 있도록 다른 참가자들의 점수를 조작하되, 영향을 받는 참가자 수를 최소로 하여야하며 이 때 영향을 받는 최소 참가자의 수를 리턴하세요.

입력은 받을 수 있는 최대 점수 cap, 나의 점수 k, 나를 제외한 참가자들의 점수가 담긴 배열 score와 본선 진출을 위해 넘어야 하는 등수 m으로 주어집니다.

출력은 위와 같이 본선에 진출할 수 있도록 점수를 조작했을 때, 점수가 변한 참가자의 최소 수를 반환하되 본선 진출이 불가능한 경우 -1을 반환합니다.

예제 1:
입력:
cap = 100
k = 70
score = [95, 90, 80, 80, 80, 70, 70, 30, 10]
m = 4
출력: 3
설명:
나의 점수 k=70점 보다 높은 점수는 95, 90, 80, 80, 80 다섯명입니다. m=4등안에 들기 위해서는 나보다 높은 점수인 사람이 3명만 있어야하므로 두 명의 점수를 줄여야하는데 80점 두 명을 각각 10점씩 낮추고 그 점수(10 x 2)를 점수가 10점인 사람한테 주면 최종적으로 점수는 [95, 90, 80, 70, 70, 70, 70, 30, 30]이 되고 나보다 점수가 높은 사람은 3명이 됩니다. 이 때 점수가 변한 참가자의 수는 3명(80, 80, 10)이므로 3을 리턴합니다.

예제 2:
입력:
cap = 100
k = 82
score = [100, 97, 97, 92, 87, 77, 77, 72, 72]
m = 4
출력: 4
예제 3:
입력:
cap = 2000
k = 1998
score = [2000, 2000, 2000, 2000, 1999]
m = 5
출력:
-1

참고 사항:
10 <=  cap (최대 점수) <= 10의 9승
0 <= k (내 점수) < cap
2 <= int[] score.length (n) <= 200,000
0 <= score의 원소들 값 <= cap
score 배열은 내림차순으로 정렬되어서 주어집니다
1 <= m <= n, score[m - 1] > k
샘플 코드:
    public static void main(String[] args) {
        System.out.println(moveNumbers(100, 70, new int[]{95, 90, 80, 80, 80, 70, 70, 30, 10}, 4)); // 3
        System.out.println(moveNumbers(100, 82, new int[]{100, 97, 97, 92, 87, 77, 77, 72, 72}, 4)); // 4
        System.out.println(moveNumbers(2000, 1998, new int[]{2000, 2000, 2000, 2000, 1999}, 5)); // -1
      }


    private static int moveNumbers(int cap, int k, int[] score, int m) {
        Set<Integer> set = new HashSet<>();
        Deque<int[]> upper = new LinkedList<>(), lower = new LinkedList<>();


        for (int i = 0; i < score.length; i++) {
          if (score[i] > k) {
            upper.addLast(new int[]{score[i], i});
          } else if (score[i] < k) {
            lower.addLast(new int[]{score[i], i});
          }
        }


        if (upper.size() < m) return 0;
       
        while (upper.size() >= m) {
          if (lower.size() == 0) return -1;
         
          int[] upperEl = upper.peekLast(), lowerEl = lower.peekLast();
          int diff = Math.min(upperEl[0] - k, k - lowerEl[0]);
          if (diff == 0) return -1;


          set.add(upperEl[1]);
          set.add(lowerEl[1]);


          upperEl[0] -= diff;
          lowerEl[0] += diff;


          if (upperEl[0] == k) {
              upper.pollLast();
          }
          if (lowerEl[0] == k) {
              lower.pollLast();
          }
        }


        return set.size();
      }
 */

// 공동 m등으로 만들기 -> m등부터 현재 등수 - 1까지의 점수를 모두 k로 만들기
class Solution {
    public int solution(int cap, int k, int[] score, int m) {
        int move = 0, count = 0;

        for (int i = m - 1; i < score.length && score[i] > k; i++) {
            move += score[i] - k;
            count++;
        }
        for (int i = score.length - 1; i >= 0 && score[i] < k && move > 0; i--) {
            move -= k - score[i];
            count++;
        }
        return move == 0 ? count : -1;
    }
}