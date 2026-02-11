import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        String s = br.readLine().trim();
        
        // Solution 로직
        int[] counts = new int[26];
        StringBuilder sb = new StringBuilder();
        
        for (char c : s.toCharArray()) {
            counts[c - 'a']++;
        }
        sb.append(counts[0]);
        for (int i = 1; i < 26; i++) {
            sb.append(" ").append(counts[i]);
        }
        
        bw.write(sb.toString());
        bw.newLine();
        
        bw.flush();
        bw.close();
        br.close();
    }
}
