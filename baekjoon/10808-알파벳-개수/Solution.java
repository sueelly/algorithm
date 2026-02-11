/**
 * 백준 10808번: 알파벳 개수
 * 
 * 알파벳 소문자로 이루어진 단어에서 각 알파벳의 개수를 구한다.
 */
public class Solution {

    /**
     * 각 알파벳(a-z)의 개수를 계산
     * 
     * @param s 알파벳 소문자로 이루어진 단어
     * @return 각 알파벳의 개수 (공백으로 구분된 문자열)
     */
    public String solve(String s) {
        int[] counts = new int[26];
        StringBuilder sb = new StringBuilder();
        
        for (char c : s.toCharArray()) {
            counts[c - 'a']++;
        }
        sb.append(counts[0]);
        for (int i = 1; i < 26; i++) {
            sb.append(" ").append(counts[i]);
        }
        return sb.toString();
    }
}
