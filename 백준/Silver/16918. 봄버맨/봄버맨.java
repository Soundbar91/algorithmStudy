import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    static int R, C, N;
    static int[][] map;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        map = new int[R][C];
        for (int i = 0; i < R; i++) {
            String str = br.readLine();
            for (int j = 0; j < C; j++) {
                char ch = str.charAt(j);
                if (ch == 'O') map[i][j] = 0;
                else map[i][j] = -1;
            }
        }

        if (N != 1) {
            for (int i = 2; i <= N; i++) {
                if (i % 2 == 0) plantBomb(i);
                else explosion(i - 3);
            }
        }
        print();
        br.close();
    }

    private static void plantBomb(int time) {
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (map[i][j] == -1) map[i][j] = time;
            }
        }
    }

    private static void explosion(int time) {
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (map[i][j] == time) {
                    map[i][j] = -1;

                    for (int k = 0; k < 4; k++) {
                        int nx = i + dx[k];
                        int ny = j + dy[k];

                        if (nx < 0 || ny < 0 || nx >= R || ny >= C) continue;
                        if (map[nx][ny] == time) continue;
                        map[nx][ny] = -1;
                    }
                }
            }
        }
    }

    private static void print() {
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (map[i][j] != -1) System.out.print('O');
                else System.out.print('.');
            }
            System.out.println();
        }
    }
}
