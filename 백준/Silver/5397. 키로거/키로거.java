import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            Stack<Character> front = new Stack<>();
            Stack<Character> back = new Stack<>();
            String string = br.readLine();

            for (char c : string.toCharArray()) {
                if (c == '<') {
                    if (!front.isEmpty()) {
                        back.add(front.pop());
                    }
                }
                else if (c == '>') {
                    if (!back.isEmpty()) {
                        front.add(back.pop());
                    }
                }
                else if (c == '-') {
                    if (!front.isEmpty()) {
                        front.pop();
                    }
                }
                else {
                    front.add(c);
                }
            }

            StringBuilder sb = new StringBuilder();
            while (!front.isEmpty()) {
                back.add(front.pop());
            }
            while (!back.isEmpty()) {
                sb.append(back.pop());
            }
            System.out.println(sb);
        }

        br.close();
    }
}
