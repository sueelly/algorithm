import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine().trim());
        int[] u = new int[n];
        for (int i = 0; i < n; i++) {
            u[i] = Integer.parseInt(br.readLine().trim());
        }

        int result = new Solution().solve(n, u);
        bw.write(String.valueOf(result));
        bw.newLine();

        bw.flush();
        bw.close();
        br.close();
    }
}

class Solution {
    public int solve(int n, int[] u) {
        java.util.Arrays.sort(u);
        Set<Integer> aPlusB = new HashSet<>();
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                aPlusB.add(u[i] + u[j]);
            }
        }
        for (int i = n - 1; i >= 0; i--) {
            int d = u[i];
            for (int j = 0; j < n; j++) {
                int diff = d - u[j];
                if (diff > 0 && aPlusB.contains(diff)) return d;
            }
        }
        return 0;
    }
}
