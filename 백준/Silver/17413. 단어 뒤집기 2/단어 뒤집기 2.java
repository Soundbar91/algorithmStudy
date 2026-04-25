import java.io.*;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        String str = br.readLine();
        boolean bool = false;

        for (char ch : str.toCharArray()){
            if (ch == '<'){
                while(!stack.empty()){
                    sb.append(stack.pop());
                }
                sb.append(ch);
                bool = true;
                continue;
            }
            else if (ch == '>'){
                sb.append(ch);
                bool = false;
                continue;
            }
            else if (ch == ' '){
                while(!stack.empty()){
                    sb.append(stack.pop());
                }
                sb.append(ch);
                continue;
            }

            if (bool){
                sb.append(ch);
            }
            else {
                stack.push(ch);
            }
        }

        while(!stack.empty()){
            sb.append(stack.pop());
        }

        System.out.println(sb);
    }
}
