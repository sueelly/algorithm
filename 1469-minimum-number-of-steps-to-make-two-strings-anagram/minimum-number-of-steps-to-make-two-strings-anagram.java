class Solution {
    public int minSteps(String s, String t) {
        int[] sAlpha = new int[26];
        int[] tAlpha = new int[26];
        int len = s.length();

        for (int i = 0; i < len; i++) {
            sAlpha[s.charAt(i) - 'a']++;
            tAlpha[t.charAt(i) - 'a']++;
        }
        int changeCount = 0; // 각 알파벳별로 s와 t에서의 개수 차이가 음수와 양수로 나뉘는데, 둘의 총 합은 같기 때문에 하나만 반영한다
        for (int i = 0; i < 26; i++) {
            if (sAlpha[i] - tAlpha[i] > 0) changeCount += sAlpha[i] - tAlpha[i];
        }
        return changeCount;
    }
}