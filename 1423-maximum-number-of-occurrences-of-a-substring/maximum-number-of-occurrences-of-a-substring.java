class Solution {
    public int maxFreq(String s, int maxLetters, int minSize, int maxSize) {
        // s.length() - minSize + 1개의 substring 생성
        int len = s.length();
        String[] substrs = new String[len - minSize + 1];
        Set<Character> alpha = new HashSet<>();
        Map<String, Integer> count = new HashMap<>();

        for (int i = 0; i < len - minSize + 1; i++) {
            substrs[i] = s.substring(i, i + minSize);
            for (int j = 0; j < minSize; j++) {
                alpha.add(substrs[i].charAt(j));
                if (alpha.size() > maxLetters) {
                    substrs[i] = null;
                    break ;
                }
            }
            if (substrs[i] != null) {
                if (!count.containsKey(substrs[i])) count.put(substrs[i], 1);
                else count.put(substrs[i], count.get(substrs[i]) + 1);
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