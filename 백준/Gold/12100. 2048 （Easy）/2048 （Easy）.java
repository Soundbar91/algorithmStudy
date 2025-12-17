import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, result = 0;
    static int[] mode; // 상 0, 하 1, 좌 2, 우 3
    static int[][] map;
    static int[][] copyMap;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());

        mode = new int[5];
        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        solve(0);
        System.out.print(result);
        br.close();
    }

    public static void solve(int depth) {
        if (depth == 5) {
            copyMap = new int[N][N];

            for (int i = 0; i < N; i++) {
                System.arraycopy(map[i], 0, copyMap[i], 0, N);
            }

            for (int i = 0; i < 5; i++) {
                move(mode[i]);
            }

            find();
        } else {
            for (int i = 0; i < 4; i++) {
                mode[depth] = i;
                solve(depth + 1);
            }
        }
    }

    public static void move(int mode) {
        if (mode == 0) {
            modeByMode1();
        } else if (mode == 1) {
            modeByMode2();
        } else if (mode == 2) {
            modeByMode3();
        } else if (mode == 3) {
            modeByMode4();
        }
    }

    public static void modeByMode1() {
        for (int i = 0; i < N; i++) {
            int index = 0;
            int block = 0;

            for (int j = 0; j < N; j++) {
                if (copyMap[j][i] != 0) {
                    if (copyMap[j][i] == block) {
                        copyMap[index - 1][i] = block * 2;
                        block = 0;
                        copyMap[j][i] = 0;
                    } else {
                        block = copyMap[j][i];
                        copyMap[j][i] = 0;
                        copyMap[index][i] = block;
                        index++;
                    }
                }
            }
        }
    }

    public static void modeByMode2() {
        for (int i = N - 1; i >= 0; i--) {
            int index = N - 1;
            int block = 0;

            for (int j = N - 1; j >= 0; j--) {
                if (copyMap[j][i] != 0) {
                    if (copyMap[j][i] == block) {
                        copyMap[index + 1][i] = block * 2;
                        block = 0;
                        copyMap[j][i] = 0;
                    } else {
                        block = copyMap[j][i];
                        copyMap[j][i] = 0;
                        copyMap[index][i] = block;
                        index--;
                    }
                }
            }
        }
    }

    public static void modeByMode3() {
        for (int i = 0; i < N; i++) {
            int index = 0;
            int block = 0;

            for (int j = 0; j < N; j++) {
                if (copyMap[i][j] != 0) {
                    if (copyMap[i][j] == block) {
                        copyMap[i][index - 1] = block * 2;
                        block = 0;
                        copyMap[i][j] = 0;
                    } else {
                        block = copyMap[i][j];
                        copyMap[i][j] = 0;
                        copyMap[i][index] = block;
                        index++;
                    }
                }
            }
        }
    }

    public static void modeByMode4() {
        for (int i = N - 1; i >= 0; i--) {
            int index = N - 1;
            int block = 0;

            for (int j = N - 1; j >= 0; j--) {
                if (copyMap[i][j] != 0) {
                    if (copyMap[i][j] == block) {
                        copyMap[i][index + 1] = block * 2;
                        block = 0;
                        copyMap[i][j] = 0;
                    } else {
                        block = copyMap[i][j];
                        copyMap[i][j] = 0;
                        copyMap[i][index] = block;
                        index--;
                    }
                }
            }
        }
    }

    public static void find() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                result = Math.max(result, copyMap[i][j]);
            }
        }
    }
}
