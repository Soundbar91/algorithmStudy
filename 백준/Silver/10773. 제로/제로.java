import java.io.*;
import java.util.*;

public class Main {

    static int K, sum;
    static Stack<Integer> stack = new Stack<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        K = Integer.parseInt(br.readLine());

        while (K-- > 0) {
            int value = Integer.parseInt(br.readLine());

            if (value != 0) {
                stack.push(value);
                sum += value;
            } else {
                sum -= stack.pop();
            }
        }

        System.out.print(sum);
    }
}
