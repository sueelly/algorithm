import java.util.List;

public class Main {

	public static void main(String[] args) {
		Solution sol = new Solution();
		String[] testInputs = {"abcbedfed", "abcdefg", "abmowodfsxadejihgepczpc"};
		String[][] testOutputs = {
				{"a", "bcb", "edfed"},
				{"a", "b", "c", "d", "e", "f", "g"},
				{"abmowodfsxad", "ejihge", "pczpc"}
		};
		int		testCase = testInputs.length;

		for (int i = 0; i < testCase; i++) {
			List<String> testResults = sol.longestUniqueSubstringSet(testInputs[i]);

			System.out.printf("\n====Test %d====%s\n", i, testInputs[i]);
			System.out.println("answer:");
			for (String s: testOutputs[i]) {
				System.out.print(s + " ");
			}
			System.out.println("\nresult:");
			for (String s: testResults) {
				System.out.print(s + " ");
			}
			System.out.print("\n");
		}
	}
}
