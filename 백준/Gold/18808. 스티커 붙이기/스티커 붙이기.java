import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int N, M, K;
    static int[][] map;
    static List<Sticker> stickers = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());

            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int[][] model = new int[r][c];

            for (int j = 0; j < r; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < c; k++) {
                    model[j][k] = Integer.parseInt(st.nextToken());
                }
            }
            stickers.add(new Sticker(r, c, model));
        }

        solve();
        br.close();
    }

    public static void solve() {
        for (int i = 0; i < stickers.size(); i++) {
            Sticker sticker = stickers.get(i);

            for (int j = 0; j < 4; j++) {
                if (!search(sticker)) {
                    sticker.rotate();
                }
                else {
                    break;
                }
            }
        }

        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 1) {
                    count++;
                }
            }
        }
        System.out.print(count);
    }

    public static boolean search(Sticker sticker) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (valid(i, j, sticker)) {
                    put(i, j, sticker);
                    return true;
                }
            }
        }

        return false;
    }

    public static boolean valid(int x, int y, Sticker sticker) {
        for (int i = 0; i < sticker.r; i++) {
            for (int j = 0; j < sticker.c; j++) {
                if (x + i < 0 || x + i >= N || y + j < 0 || y + j >= M) {
                    return false;
                }
                if (map[x + i][y + j] == 1 && sticker.model[i][j] == 1) {
                    return false;
                }
            }
        }

        return true;
    }

    public static void put(int x, int y, Sticker sticker) {
        for (int i = 0; i < sticker.r; i++) {
            for (int j = 0; j < sticker.c; j++) {
                if (sticker.model[i][j] == 1) {
                    map[x + i][y + j] = sticker.model[i][j];
                }
            }
        }
    }

    public static class Sticker {
        int r;
        int c;
        int[][] model;

        public Sticker(int r, int c, int[][] model) {
            this.r = r;
            this.c = c;
            this.model = model;
        }

        public void rotate() {
            int[][] tmp = new int[c][r];

            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    tmp[j][r - 1 - i] = model[i][j];
                }
            }

            r = model[0].length;
            c = model.length;
            model = tmp;
        }
    }
}
