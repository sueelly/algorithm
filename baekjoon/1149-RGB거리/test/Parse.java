/**
 * 1149번: RGB거리 - JSON input 파싱 후 Solution.solve() 호출
 */
public class Parse implements ParseAndCallSolve {
    @Override
    public String parseAndCallSolve(Solution sol, String input) {
        String[] lines = input.trim().split("\n");
        int n = Integer.parseInt(lines[0].trim());
        int[][] costs = new int[n][3];
        for (int i = 0; i < n; i++) {
            String[] parts = lines[i + 1].trim().split("\\s+");
            costs[i][0] = Integer.parseInt(parts[0]);
            costs[i][1] = Integer.parseInt(parts[1]);
            costs[i][2] = Integer.parseInt(parts[2]);
        }
        return String.valueOf(sol.solve(n, costs));
    }
}
