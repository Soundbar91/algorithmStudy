import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

class Main {
    static Deque<Integer> deque = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        while (N-- > 0) {
            String[] commend = br.readLine().split(" ");

            switch (commend[0]) {
                case "1" :
                    deque.addFirst(Integer.parseInt(commend[1]));
                    break;
                case "2" :
                    deque.addLast(Integer.parseInt(commend[1]));
                    break;
                case "3" :
                    sb.append(deque.isEmpty() ? "-1" : deque.pollFirst()).append('\n');
                    break;
                case "4" :
                    sb.append(deque.isEmpty() ? "-1" : deque.pollLast()).append('\n');
                    break;
                case "5" :
                    sb.append(deque.size()).append('\n');
                    break;
                case "6" :
                    sb.append(deque.isEmpty() ? "1" : "0").append('\n');
                    break;
                case "7" :
                    sb.append(deque.isEmpty() ? "-1" : deque.getFirst()).append('\n');
                    break;
                default :
                    sb.append(deque.isEmpty() ? "-1" : deque.getLast()).append('\n');
                    break;
            }
        }

        System.out.print(sb);
        br.close();
    }
}
