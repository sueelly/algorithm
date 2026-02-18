class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        // 알파벳별 순서를 저장하는 배열
        short[] alpOrder = new short[26];
        short i, j;

        for (i = 0; i < order.length(); i++) {
            alpOrder[order.charAt(i) - 'a'] = i;
        }
        for (i = 1; i < words.length; i++) {
            for (j = 0; j < words[i - 1].length() && j < words[i].length() && words[i - 1].charAt(j) == words[i].charAt(j); j++) continue ;
            if (j == words[i].length() && words[i - 1].length() > words[i].length()) return false;
            if (j < words[i - 1].length() && j < words[i].length() 
            && alpOrder[words[i].charAt(j) - 'a'] - alpOrder[words[i - 1].charAt(j) - 'a'] < 0) return false;
        }
        return true;
    }
}