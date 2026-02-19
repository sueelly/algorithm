import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while (true) {
            String line = br.readLine();
            if (line == null || line.equals(".")) {
                break;
            }
            String result = solve(line);
            bw.write(result);
            bw.newLine();
        }

        bw.flush();
        bw.close();
        br.close();
    }

    static String solve(String line) {
        int index = 0, len = line.length();
        char[] stack = new char[len];

        for (char c : line.toCharArray()) {
            if (c == '(' || c == '[') {
                stack[index++] = c;
            } else if (c == ')') {
                if (index == 0 || stack[--index] != '(') {
                    return "no";
                }
            } else if (c == ']') {
                if (index == 0 || stack[--index] != '[') {
                    return "no";
                }
            }
        }
        if (index != 0) return "no";
        return "yes";
    }
}
