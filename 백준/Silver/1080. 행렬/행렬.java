import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int M;
    static int result;
    static int[][] A;
    static int[][] B;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        A = new int[N][M];
        B = new int[N][M];

        inputArr(A);
        inputArr(B);

        for (int i = 0; i < N - 2; i++) {
            for (int j = 0; j < M - 2; j++) {
                if (A[i][j] != B[i][j]) {
                    flip(j, i);
                    result++;
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (A[i][j] != B[i][j]) {
                    System.out.print(-1);
                    System.exit(0);
                }
            }
        }

        System.out.print(result);
    }

    public static void inputArr(int[][] Arr) throws IOException {
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                Arr[i][j] = str.charAt(j) - '0';
            }
        }
    }

    public static void flip(int x, int y) {
        int[] dx = {0, 1, 2, 0, 1, 2, 0, 1, 2};
        int[] dy = {0, 0, 0, 1, 1, 1, 2, 2, 2};

        for (int i = 0; i < 9; i++) {
            int ux = x + dx[i];
            int uy = y + dy[i];

            if (ux >= M || uy >= N) continue;
            A[uy][ux] = A[uy][ux] == 0 ? 1 : 0;
        }
    }
}
