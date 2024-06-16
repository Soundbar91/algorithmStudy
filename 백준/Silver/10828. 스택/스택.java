import java.io.*;
import java.util.Stack;

public class Main {
    static int N;
    static String[] orders;
    static Stack<Integer> stack = new Stack<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        orders = new String[N];
        for (int i = 0; i < N; i++) orders[i] = br.readLine();

        solve();
    }

    public static void solve() {
        for (String str : orders) {
            String[] strArray = str.split(" ");

            if (strArray[0].equals("push")) {
                stack.push(Integer.parseInt(strArray[1]));
            } else if (strArray[0].equals("pop")) {
                System.out.println(stack.isEmpty() ? -1 : stack.pop());
            } else if (strArray[0].equals("size")) {
                System.out.println(stack.size());
            } else if (strArray[0].equals("empty")) {
                System.out.println(stack.isEmpty() ? 1 : 0);
            } else {
                System.out.println(stack.isEmpty() ? -1 : stack.peek());
            }
        }
    }
}
