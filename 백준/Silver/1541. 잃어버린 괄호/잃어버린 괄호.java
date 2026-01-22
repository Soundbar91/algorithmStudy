import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), "+-", true);

        Deque<String> deque = new ArrayDeque<>();
        while (st.hasMoreTokens()){
            String s = st.nextToken();

            if (s.equals("+")) {
                deque.addLast(String.valueOf(Integer.parseInt(deque.pollLast()) + Integer.parseInt(st.nextToken())));
            } else if (s.equals("-")) {
                deque.addLast(st.nextToken());
            } else {
                deque.addLast(s);
            }
        }

        int result = Integer.parseInt(deque.pollFirst());
        while (!deque.isEmpty()){
            result -= Integer.parseInt(deque.pollFirst());
        }

        System.out.print(result);
        br.close();
    }
}