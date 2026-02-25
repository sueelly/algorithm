/**
 * 6550번: 각 줄에서 s와 t를 분리하여 solve 호출
 */
public class Parse implements ParseAndCallSolve {
    @Override
    public String parseAndCallSolve(Solution sol, String input) {
        String[] lines = input.split("\n");
        StringBuilder sb = new StringBuilder();
        for (String line : lines) {
            if (line.trim().isEmpty()) continue;
            String[] parts = line.split(" ", 2);
            String s = parts[0];
            String t = parts[1];
            if (sb.length() > 0) {
                sb.append("\n");
            }
            sb.append(sol.solve(s, t));
        }
        return sb.toString();
    }
}
