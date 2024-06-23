import java.io.*;
import java.util.Stack;

public class Main {
    static String formula;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        formula = br.readLine();

        System.out.print(solve());
        br.close();
    }

    public static String solve() {
        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        char[] charArray = formula.toCharArray();

        for (char c : charArray) {
            if (c == '(') stack.push(c);
            else if (c == ')') {
                while (!stack.isEmpty()) {
                    if (stack.peek() == '(') {
                        stack.pop();
                        break;
                    }
                    sb.append(stack.pop());
                }
            }
            else if (c == '+' || c == '-' || c == '*' || c == '/') {
               while (!stack.isEmpty()) {
                   char pop = stack.peek();
                   if (precedence(pop) >= precedence(c)) sb.append(stack.pop());
                   else break;
               }
               stack.push(c);
            }
            else sb.append(c);
        }

        while (!stack.isEmpty()) sb.append(stack.pop());

        return sb.toString();
    }

    public static int precedence(char ch){
        if (ch == '(' || ch == ')') return 0;
        else if(ch == '+' || ch == '-') return 1;
        else return 2;
    }
}
