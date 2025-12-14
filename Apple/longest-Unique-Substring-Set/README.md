Longest Unique Substring Set - Apple

문자열 s가 주어집니다. 문자열 s를 최대한 많은 개수의 substring으로 나누는데, 각 substring에 들어있는 문자들은 다른 substring에는 존재하지 않아야 합니다. 즉 각각의 substring들은 각각 유일한 문자들로만 이루어진 문자열이어야 합니다.

최대한 많은 substring으로 나눈 문자열들을 리턴하세요.

예제 1:
입력: s = “abcbedfed”
출력: [“a”, “bcb”, “edfed”]
설명: 3개의 문자열 a, bcb, edfed로 나누어질 수 있고 각 문자열은 유일한 문자들로만 이루어져있습니다.
a = [a]
bcb = [b, c]
edfed = [e, d, f]

예제 2:
입력: s = “abcdefg”
출력: [“a”, “b”, “c”, “d”, “e”, “f”, “g”]

예제 3:
입력: s = “abmowodfsxadejihgepczpc”
출력: [“abmowodfsxad”, “ejihge”, “pczpc”]
설명:
abmowodfsxad = [a, b, m, o, w, d, f, s, x]
ejihge = [e, j, i, h, g]
pczpc = [p, c, z]

제약사항:
1 <= s.length <= 2^30
1 <= result.size() <= 26
s는 알파벳 소문자로만 이루어져있습니다


구현할 method:
public List<String> longestUniqueSubstringSet(String s) {
	// implementation
}


