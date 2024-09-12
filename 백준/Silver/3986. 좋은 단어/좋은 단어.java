import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class Main {
    static int N;
    static List<String> strings = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            strings.add(br.readLine());
        }

        System.out.print(solve());
        br.close();
    }

    public static int solve() {
        int count = 0;

        for (String string : strings) {
            if (string.length() % 2 != 0) continue;
            if (result(string)) count++;
        }

        return count;
    }

    public static boolean result(String string) {
        Stack<Character> stack = new Stack<>();
        stack.push(string.charAt(0));

        for (int i = 1; i < string.length(); i++) {
            if (!stack.isEmpty() && stack.peek() == string.charAt(i)) {
                stack.pop();
            }
            else stack.push(string.charAt(i));
        }

        return stack.isEmpty();
    }
}
