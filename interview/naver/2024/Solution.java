import java.util.Arrays;

/**
 * 행복한 식물 - 네이버 2024 신입 공채

각 식물들의 초기 상태를 나타내는 정수 배열 emotions가 주어집니다. emotions[i]는 (i + 1)번째 식물의 초기 상태를 나타냅니다. (식물의 번호는 1번부터 시작) 식물은 상태값이 0보다 크면 기분이 좋은 것으로 간주합니다.

또한 각 사이클마다 물을 주는 식물 번호를 나타내는 정수 배열 orders도 함께 주어집니다. orders[i]는 (i + 1)번째 사이클에 해당 식물에게 물을 주었다는것을 나타내며, 한 사이클에 하나의 식물에만 물을 줄 수 있습니다.
물을 받은 식물은 현재의 기분과는 관계없이 항상 초기 상태로 돌아가게됩니다. (0이 된 경우는 제외)

식물들은 한 사이클이 지날 때 마다 상태값이 1씩 감소하게 되며 0이 되면 더 이상 기분이 좋지 않습니다.
또한 한 번 기분이 0이된 식물은 다시 물을 주어도 기분이 좋아지지 않습니다.

주어진 emotions와 orders를 바탕으로 각 사이클마다 기분 좋은 식물의 수를 리턴하세요.

예제 1:
입력: emotions = [2, 3, 1, 2], orders = [3, 1, 2, 1, 4, 1]
출력: results = [4, 2, 2, 2, 2, 1]
설명:
각 사이클 별 식물의 기분들과 기분 좋은 식물의 수는 아래와 같습니다.
초기상태: [2, 3, 1, 2]
사이클 1: [1, 2, 1, 1] - 총 4 식물
사이클 2: [2, 1, 0, 0] - 총 2 식물
사이클 3: [1, 3, 0, 0] - 총 2 식물
사이클 4: [2, 2, 0, 0] - 총 2 식물
사이클 5: [1, 1, 0, 0] - 총 2 식물 (4는 이미 0이므로 복구되지 않음)
사이클 6: [2, 0, 0, 0] - 총 1 식물
따라서 사이클 별 기분좋은 식물의 수인 [4, 2, 2, 2, 2, 1]을 리턴합니다.

예제 2:
입력: emotions = [5, 5, 5], orders = [1, 2, 1, 2, 3]
출력: results = [3, 3, 3, 3, 3]

예제 3:
입력: emotions = [5, 5, 5], orders = [1, 2, 1, 2, 1]
출력: results = [3, 3, 3, 3, 2]

예제 4:
입력: emotions = [2, 1, 3, 4, 3], orders = [2, 2, 2, 2, 5, 5, 5]
출력: results = [5, 4, 2, 1, 0, 0, 0]

참고 사항:
emotions.length = 식물의 개수
orders.length = 사이클의 횟수
orders.length = results.length

 */

class Solution {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[] {2, 3, 1, 2}, new int[] {3, 1, 2, 1, 4, 1}))); // [4, 2, 2, 2, 2, 1]
        System.out.println(Arrays.toString(solution(new int[] {5, 5, 5}, new int[] {1, 2, 1, 2, 3}))); // [3, 3, 3, 3, 3]
        System.out.println(Arrays.toString(solution(new int[] {5, 5, 5}, new int[] {1, 2, 1, 2, 1}))); // [3, 3, 3, 3, 2]
        System.out.println(Arrays.toString(solution(new int[] {2, 1, 3, 4, 3}, new int[] {2, 2, 2, 2, 5, 5, 5}))); // [5, 4, 2, 1, 0, 0, 0]
    }

    // 식물의 개수 * 사이클의 횟수 -> 식물의 개수 + 사이클의 개수로!
    public static int[] solution(int[] emotions, int[] orders) {
        int[] original = Arrays.copyOf(emotions, emotions.length);
        int[] results = new int[orders.length];
        int order, count = emotions.length;

        // 최종 살아남는 사이클 수 설정
        for (int i = 0; i < orders.length; i++) {
            if (emotions[(order = orders[i] - 1)] > i) emotions[order] += original[order];
        }
        // 삭뮬 수가 -1이 되는 구간 기록
        for (int emotion : emotions) {
            if (emotion >= 0 && emotion < orders.length) results[emotion]--;
        }
        // 전체 적용
        for (int i = 0; i < orders.length; i++) {
            count += results[i]; // emotions.length에서 -1씩
            results[i] = count;
        }
        return results;

        // for (int i = 0; i < orders.length; i++) {
        //     for (int j = 0; j < emotions.length; j++) {
        //         if (j == orders[i] - 1 && emotions[j] > 0) emotions[j] = original[j];
        //         else if (emotions[j] > 0) emotions[j]--;
        //         if (emotions[j] > 0) results[i]++;
        //     }
        // }

        // return results;
    }
}