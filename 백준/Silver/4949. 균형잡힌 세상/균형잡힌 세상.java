import java.io.*;
import java.util.Objects;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        while(true){
            Stack<Character> stack = new Stack<>();
            boolean bool = false;

            String str = br.readLine();
            if (Objects.equals(str, ".")) break;

            for (char ch : str.toCharArray()){
                if (ch == '.' && !stack.empty()){
                    sb.append("no" + '\n');
                    bool = true;
                    break;
                }

                if (ch == '(' || ch == '[') stack.push(ch);

                else if (ch == ')'){
                    if (stack.empty() || stack.peek() != '(') {
                        sb.append("no" + '\n');
                        bool = true;
                        break;
                    }
                    else stack.pop();
                }

                else if (ch == ']'){
                    if (stack.empty() || stack.peek() != '[') {
                        sb.append("no" + '\n');
                        bool = true;
                        break;
                    }
                    else stack.pop();
                }
            }

            if(!bool) sb.append("yes" + '\n');
        }
        System.out.print(sb);
    }
}
