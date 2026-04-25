import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int result;
    static int[][] map;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        map = new int[5][5];
        visited = new boolean[5][5];

        for (int i = 0; i < 5; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < 5; i++) {
            boolean cross = false;
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                int call = Integer.parseInt(st.nextToken());
                result++;
                check(call);
                if (isBingo()) {
                    cross = true;
                    break;
                }
            }
            if (cross) break;
        }

        System.out.print(result);
        br.close();
    }

    public static void check(int call) {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (map[i][j] == call) {
                    visited[i][j] = true;
                    break;
                }
            }
        }
    }

    public static boolean isBingo() {
        int count = 0;

        for (int i = 0; i < 5; i++) {
            boolean cross = true;

            for (int j = 0; j < 5; j++) {
                if (!visited[j][i]) {
                    cross = false;
                    break;
                }
            }

            if (cross) count++;
        }

        for (int i = 0; i < 5; i++) {
            boolean cross = true;

            for (int j = 0; j < 5; j++) {
                if (!visited[i][j]) {
                    cross = false;
                    break;
                }
            }

            if (cross) count++;
        }

        boolean cross = true;
        for (int i = 0; i < 5; i++) {
            if (!visited[i][i]) {
                cross = false;
                break;
            }
        }
        if (cross) count++;

        cross = true;
        for (int i = 0; i < 5; i++) {
            if (!visited[i][4 - i]) {
                cross = false;
                break;
            }
        }
        if (cross) count++;

        return count >= 3;
    }
}
