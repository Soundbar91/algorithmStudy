import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static List<int[]> circles = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());

            int left = x - r;
            int right = x + r;

            circles.add(new int[]{0, left, x});
            circles.add(new int[]{1, right, x});
        }

        System.out.print(solve() ? "YES" : "NO");
        br.close();
    }

    public static boolean solve() {
        circles.sort(Comparator.comparingInt(o -> o[1]));
        Stack<int[]> stack = new Stack<>();

        for (int[] circle : circles) {
            if (circle[0] == 0) stack.push(circle);
            else {
                if (stack.peek()[2] != circle[2]) return false;
                else stack.pop();
            }
        }

        return true;
    }
}
