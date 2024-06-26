import java.io.*;
import java.util.Objects;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String bracket = br.readLine();
        System.out.print(valid(bracket) ? solve(bracket) : 0);
        br.close();
    }

    public static boolean valid(String s) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '(' || c == '[') stack.push(c);
            else if (stack.empty()) return false;
            else {
                char pop = stack.pop();
                if (c == ')' && pop != '(' || c == ']' && pop != '[') return false;
            }
        }

        return stack.isEmpty();
    }

    public static int solve(String bracket) {
        Stack<String> stack = new Stack<>();
        int result = 0;

        for (int i = 0; i < bracket.length(); i++) {
            char c = bracket.charAt(i);

            if (c == '(' || c == '[') stack.push(String.valueOf(c));
            else if (c == ')') calc(stack, "(", 2);
            else calc(stack, "[", 3);
        }

        for (String c : stack) result += Integer.parseInt(c);

        return result;
    }

    public static void calc(Stack<String> stack, String bracket, int weight) {
        if (Objects.equals(stack.peek(), bracket)) {
            stack.pop();
            stack.push(String.valueOf(weight));
        }
        else {
            int temp = 0;

            while (!Objects.equals(stack.peek(), bracket)) {
                temp += Integer.parseInt(stack.pop());
            }
            stack.pop();

            temp *= weight;
            stack.push(String.valueOf(temp));
        }
    }
}
