class Solution {
    public int countBinarySubstrings(String s) {
        int count = 0, prev = 0, curr = 1;

        // 0 또는 1의 연속된 개수를 저장하면 다음과 같다: 001101010 -> 2 2 1 1 1 1 1 1
        // 해당 갯수를 가장 최근 것과 바로 이전의 것만 안다면 해당 조합에서 가능한 부분문자열 개수를 알 수 있다: 2 2 -> 1개와 1개, 2개와 2개로 총 2개
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                curr++;
            } else {
                count += curr >= prev ? prev : curr;
                prev = curr;
                curr = 1;
            }
        }
        return count + (curr >= prev ? prev : curr); // last case 
    }
}