/**
 * 백준 4949번: 균형잡힌 세상
 *
 * [문제 요약]
 * 소괄호 (), 대괄호 []만 고려했을 때 괄호 균형이 맞는지 판단
 *
 * @param line 한 줄 문자열 (영문, 공백, (), [] 포함, '.'으로 끝남)
 * @return 균형이면 "yes", 아니면 "no"
 */
public class Solution {

    public String solve(String line) {
        int index = 0, len = line.length();
        char[] stack = new char[len];

        for (char c : line.toCharArray()) {
            if (c == '(' || c == '[') {
                stack[index++] = c;
            } else if (c == ')') {
                if (index == 0 || stack[--index] != '(') {
                    // System.err.println("틀림: ) 짝 없음 또는 ( 아님");
                    return "no";
                }
            } else if (c == ']') {
                if (index == 0 || stack[--index] != '[') {
                    // System.err.println("틀림: ] 짝 없음 또는 [ 아님");
                    return "no";
                }
            }
        }
        if (index != 0) return "no";
        return "yes";
    }
}
