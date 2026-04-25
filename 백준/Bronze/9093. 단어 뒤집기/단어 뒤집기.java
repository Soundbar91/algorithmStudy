import java.io.*;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());

        while(n-- > 0){
            Stack<Character> stack = new Stack<>();
            String str = br.readLine() + "\n";

            for (char ch : str.toCharArray()){
                if (ch == ' ' || ch == '\n'){
                    while (!stack.empty()){
                        bw.write(stack.pop());
                    }
                    bw.write(ch);
                }
                else stack.push(ch);
            }
        }
        bw.flush();
    }
}
