import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        // 입력: 방 번호 N
        int n = Integer.parseInt(br.readLine().trim());
        
        // Solution 로직
        int[] numberCounts = new int[9];
        int max = 0;

        while (n > 0) {
            if (n % 10 == 9) numberCounts[6]++;
            else numberCounts[n % 10]++;
            n /= 10;
        }
        numberCounts[6] = numberCounts[6] / 2 + (numberCounts[6] & 1);
        for (int i = 0; i < 9; i++) {
            if (numberCounts[i] > max) max = numberCounts[i];
        }
        
        // 출력
        bw.write(String.valueOf(max));
        bw.newLine();
        
        bw.flush();
        bw.close();
        br.close();
    }
}
