class Solution {
    private String s;
    private int maxLetters;
    private boolean[] alphabets = new boolean[26];

    private boolean isValidSubstring(int start, int end) {
        int unique = 0;
        char c;

        Arrays.fill(alphabets, false);

        for (int i = start; i < end && unique <= maxLetters; i++) {
            c = s.charAt(i);
            if (alphabets[c - 'a']) continue ;
            alphabets[c - 'a'] = true;
            unique += 1;
        }
        return unique <= maxLetters;
    }

    public int maxFreq(String s, int maxLetters, int minSize, int maxSize) {
        this.s = s;
        this.maxLetters = maxLetters;
        Map<String, Integer> substrings = new HashMap<>();
        String substring;
        int maxCount = 0;

        for (int i = 0; i <= s.length() - minSize; i++) {
            if (isValidSubstring(i, i + minSize)) {
                substring = s.substring(i, i + minSize);
                substrings.put(substring, substrings.getOrDefault(substring, 0) + 1);
            }
        }
        for (int count: substrings.values()) {
            if (maxCount < count) maxCount = count;
        }
        return maxCount;
    }
}