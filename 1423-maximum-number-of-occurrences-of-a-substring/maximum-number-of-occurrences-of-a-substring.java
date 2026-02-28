class Solution {
    public int maxFreq(String s, int maxLetters, int minSize, int maxSize) {
        // s.length() - minSize + 1개의 substring 생성
        int len = s.length(), letters;
        String substr;
        boolean[] alpha = new boolean[26];
        Map<String, Integer> count = new HashMap<>();

        for (int i = 0; i < len - minSize + 1; i++) {
            substr = s.substring(i, i + minSize);
            for (int j = 0; j < minSize; j++) {
                alpha[substr.charAt(j) - 'a'] = true;
            }
            letters = 0;
            for (int j = 0; j < 26; j++) {
                if (alpha[j]) letters++;
            }
            if (letters <= maxLetters) {
                if (!count.containsKey(substr)) count.put(substr, 1);
                else count.put(substr, count.get(substr) + 1);
            }
            
            Arrays.fill(alpha, false);
        }
        int max = 0;
        for (Integer n : count.values()) {
            if (n > max) max = n;
        }
        return max;
    }
}