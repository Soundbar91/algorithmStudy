import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Stack<Character> left = new Stack<>();
        Stack<Character> right = new Stack<>();

        String str = br.readLine();
        for (char ch : str.toCharArray()){
            left.push(ch);
        }

        int num = Integer.parseInt(br.readLine());

        for (int i = 0 ; i < num; i++){
            String line = br.readLine();
            StringTokenizer st = new StringTokenizer(line);

            char order = st.nextToken().charAt(0);

            if (order == 'P') {
                String insert = st.nextToken();
                left.push(insert.charAt(0));
            }
            else if (order == 'L'){
                if (!left.empty()){
                    right.push(left.pop());
                }
                else {
                    continue;
                }
            }
            else if (order == 'D'){
                if (!right.empty()){
                    left.push(right.pop());
                }
                else {
                    continue;
                }
            }
            else {
                if (!left.empty()){
                    left.pop();
                }
                else {
                    continue;
                }
            }
        }

        while(!left.empty()){
            sb.append(left.pop());
        }
        sb.reverse();
        while(!right.empty()){
            sb.append(right.pop());
        }
        System.out.println(sb);
    }
}
