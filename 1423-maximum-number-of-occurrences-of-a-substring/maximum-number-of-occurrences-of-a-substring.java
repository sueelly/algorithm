class Solution {
    public int maxFreq(String s, int maxLetters, int minSize, int maxSize) {
        // s.length() - minSize + 1개의 substring 생성
        int len = s.length();
        String substr;
        Set<Character> alpha = new HashSet<>();
        Map<String, Integer> count = new HashMap<>();

        for (int i = 0; i < len - minSize + 1; i++) {
            substr = s.substring(i, i + minSize);
            for (int j = 0; j < minSize; j++) {
                alpha.add(substr.charAt(j));
                if (alpha.size() > maxLetters) {
                    substr = null;
                    break ;
                }
            }
            if (substr != null) {
                if (!count.containsKey(substr)) count.put(substr, 1);
                else count.put(substr, count.get(substr) + 1);
            }
            alpha.clear();
        }
        int max = 0;
        for (Integer n : count.values()) {
            if (n > max) max = n;
        }
        return max;
    }
}