import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

class Solution {

	public List<String> longestUniqueSubstringSet(String s) {
		
		List<String>	substrList = new ArrayList<>();
		int[]			start = new int[26], end = new int[26];
		int 			len = s.length(), i, j, c, startPoint;

		Arrays.fill(start, -1);
		Arrays.fill(end, -1);
		for (i = 0; i < len; i++) {
			c = s.charAt(i) - 'a';
			if (start[c] != -1) {
				start[c] = i;
			}
			end[c] = i;
		}
		for (i = 0; i < len; i++) {
			// Update substring until there is no repeated characters,
			// updating last index of substring
			startPoint = i;
			for (j = end[(int)(s.charAt(i) - 'a')]; i < j; i++) {
				c = s.charAt(i) - 'a';
				if (j < end[c]) {
					j = end[c];
				}
			}
			// Add substring
			substrList.add(s.substring(startPoint, j + 1));
		}
		return substrList;
	}
}
