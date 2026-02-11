import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        // 입력 파싱
        int n = Integer.parseInt(br.readLine().trim());
        
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        int x = Integer.parseInt(br.readLine().trim());
        
        // Solution 로직
        int[] count = new int[x];
        int result = 0;

        for (int i = 0; i < n; i++) {
            if (arr[i] < x) count[arr[i]]++;
        }
        for (int i = 1; i < (x + 1) / 2; i++) {
            result += count[i] * count[x - i];
        }
        
        // 출력
        bw.write(String.valueOf(result));
        bw.newLine();
        
        bw.flush();
        bw.close();
        br.close();
    }
}
