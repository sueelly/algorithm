/**
 * 백준 6550번: 부분 문자열
 *
 * [문제 요약]
 * 문자열 s가 문자열 t의 부분 문자열(subsequence)인지 판단
 *
 * @param s 부분 문자열 후보
 * @param t 원본 문자열
 * @return s가 t의 부분 문자열이면 "Yes", 아니면 "No"
 */
public class Solution {

    public String solve(String s, String t) {
        int i = 0, j = 0, sLen = s.length(), tLen = t.length();

        while (i < sLen && j < tLen) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
            }
            j++;
        }
        return i == sLen ? "Yes" : "No";
    }
}
