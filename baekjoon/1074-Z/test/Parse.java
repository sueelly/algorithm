/**
 * 1074번: Z - JSON input 파싱 후 Solution.solve() 호출
 */
public class Parse implements ParseAndCallSolve {
    @Override
    public String parseAndCallSolve(Solution sol, String input) {
        String[] parts = input.trim().split("\\s+");
        int n = Integer.parseInt(parts[0]);
        int r = Integer.parseInt(parts[1]);
        int c = Integer.parseInt(parts[2]);
        return String.valueOf(sol.solve(n, r, c));
    }
}
