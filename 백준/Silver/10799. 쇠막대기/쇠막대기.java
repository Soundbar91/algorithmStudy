import java.io.*;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String bracket = br.readLine();
        System.out.print(solve(bracket));
        br.close();
    }

    public static int solve(String bracket) {
        Stack<Character> stack = new Stack<Character>();
        char[] charArray = bracket.toCharArray();
        char prev = '\0';
        int result = 0;

        for (char c : charArray) {
            if (c == '(') stack.push(c);
            else {
                stack.pop();
                if (prev == ')') result++;
                else result += stack.size();
            }
            prev = c;
        }

        return result;
    }
}
