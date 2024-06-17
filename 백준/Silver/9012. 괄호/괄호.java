import java.io.*;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            String str = br.readLine();
            System.out.println(solve(str) ? "YES" : "NO");
        }

        br.close();
    }

    public static boolean solve(String str) {
        Stack<Character> stack = new Stack<>();
        char[] charArray = str.toCharArray();

        for (char c : charArray) {
            if (c == '(') stack.push(c);
            else if (c == ')') {
                if (stack.isEmpty()) return false;
                else stack.pop();
            }
        }

        return stack.isEmpty();
    }
}
