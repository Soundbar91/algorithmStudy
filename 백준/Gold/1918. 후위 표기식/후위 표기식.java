import java.io.*;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        String str = br.readLine();

        for (char ch : str.toCharArray()){
            if (ch == '('){
                stack.push(ch);
            }
            else if (ch == ')'){
                while(!stack.empty()){
                    if (stack.peek() == '('){
                        stack.pop();
                        break;
                    }
                    sb.append(stack.pop());
                }
            }
            else if (ch == '+' || ch == '-' || ch == '*' || ch == '/'){
                while (!stack.empty()){
                    char pop = stack.peek();
                    if (precedence(ch) <= precedence(pop)){
                        sb.append(stack.pop());
                    }
                    else break;
                }
                stack.push(ch);
            }
            else {
                sb.append(ch);
            }
        }
        while(!stack.empty()){
            sb.append(stack.pop());
        }
        System.out.println(sb);
    }

    public static int precedence(char ch){
        if (ch == '(' || ch == ')'){
            return 0;
        }
        else if(ch == '+' || ch == '-'){
            return 1;
        }
        else if(ch == '*' || ch == '/'){
            return 2;
        }
        else return -1;
    }
}
