import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int[][] map = new int[9][9];
    static List<Point> points = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for (int i = 0; i < 9; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 9; j++) {
                int value = Integer.parseInt(st.nextToken());
                map[i][j] = value;

                if (value == 0) points.add(new Point(i, j));
            }
        }

        solve(0);
    }

    public static void solve(int depth) {
        if (depth == points.size()) {
            printResult();
            System.exit(0);
        }
        else {
            Point point = points.get(depth);
            int x = point.x;
            int y = point.y;

            for (int i = 1; i <= 9; i++) {
                if (check(x, y, i)) {
                    map[x][y] = i;
                    solve(depth + 1);
                    map[x][y] = 0;
                }
            }
        }
    }


    public static boolean check(int x, int y, int value) {
        for (int i = 0; i < 9; i++) {
            if (map[x][i] == value || map[i][y] == value) return false;
        }

        int start = (x / 3) * 3;
        int end = (y / 3) * 3;

        for (int i = start; i < start + 3; i++) {
            for (int j = end; j < end + 3; j++) {
                if (map[i][j] == value) return false;
            }
        }

        return true;
    }

    public static void printResult() {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
