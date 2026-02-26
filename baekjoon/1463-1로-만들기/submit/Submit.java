import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine().trim());
        int result = new Solution().solve(n);
        bw.write(String.valueOf(result));
        bw.newLine();

        bw.flush();
        bw.close();
        br.close();
    }
}

class Solution {
    public int solve(int n) {
        if (n == 1) return 0;
        int[] dp = new int[n + 1];

        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1];
            if (i % 3 == 0 && dp[i / 3] < dp[i]) dp[i] = dp[i / 3];
            if ((i & 1) == 0 && dp[i >> 1] < dp[i]) dp[i] = dp[i >> 1];
            dp[i]++;
        }
        return dp[n];
    }
}
