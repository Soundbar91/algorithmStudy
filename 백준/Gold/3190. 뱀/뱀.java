import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N, K, L, time, mode = 0;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int[][] map;
    static Queue<Order> orders = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        K = Integer.parseInt(br.readLine());
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken()) - 1;

            map[r][c] = 2;
        }

        L = Integer.parseInt(br.readLine());
        for (int i = 0; i < L; i++) {
            st = new StringTokenizer(br.readLine());
            int X = Integer.parseInt(st.nextToken());
            char C = st.nextToken().charAt(0);
            orders.add(new Order(X, C));
        }

        solve();
        br.close();
    }

    public static void solve() {
        Deque<int[]> snake = new LinkedList<>();
        snake.add(new int[] {0, 0});
        map[0][0] = 1;

        while (true) {
            int[] cur = snake.peekFirst();

            int nx = cur[0] + dx[mode];
            int ny = cur[1] + dy[mode];
            time++;

            if (!valid(nx, ny) || map[nx][ny] == 1) {
                break;
            }

            if (map[nx][ny] == 0) {
                int[] last = snake.pollLast();
                map[last[0]][last[1]] = 0;
            }

            map[nx][ny] = 1;
            snake.addFirst(new int[] {nx, ny});

            if (!orders.isEmpty()) {
                Order order = orders.peek();
                if (order.X == time) {
                    turn(order.C);
                    orders.poll();
                }
            }

        }

        System.out.print(time);
    }

    public static void turn(char C) {
        if (C == 'D') {
            if (mode == 0) mode = 1;
            else if (mode == 1) mode = 2;
            else if (mode == 2) mode = 3;
            else if (mode == 3) mode = 0;
        } else if (C == 'L') {
            if (mode == 0) mode = 3;
            else if (mode == 1) mode = 0;
            else if (mode == 2) mode = 1;
            else if (mode == 3) mode = 2;
        }
    }

    public static boolean valid(int x, int y) {
        return (x >= 0 && x < N && y >= 0 && y < N);
    }

    public static class Order {
        int X;
        char C;

        public Order(int X, char C) {
            this.X = X;
            this.C = C;
        }
    }
}
