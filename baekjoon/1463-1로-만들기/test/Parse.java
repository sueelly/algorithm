/**
 * 1463번: 1로 만들기 - JSON input 파싱 후 Solution.solve() 호출
 */
public class Parse implements ParseAndCallSolve {
    @Override
    public String parseAndCallSolve(Solution sol, String input) {
        int n = Integer.parseInt(input.trim());
        return String.valueOf(sol.solve(n));
    }
}
