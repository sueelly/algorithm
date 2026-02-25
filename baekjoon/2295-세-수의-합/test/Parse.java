/**
 * 2295번: 세 수의 합 - JSON input 파싱 후 Solution.solve(n, u) 호출
 */
public class Parse implements ParseAndCallSolve {
    @Override
    public String parseAndCallSolve(Solution sol, String input) {
        String[] lines = input.split("\n");
        int n = Integer.parseInt(lines[0].trim());
        int[] u = new int[n];
        for (int i = 0; i < n; i++) {
            u[i] = Integer.parseInt(lines[i + 1].trim());
        }
        return String.valueOf(sol.solve(n, u));
    }
}
