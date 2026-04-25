import java.io.*;
import java.util.Arrays;

public class Main {
    static int N;
    static int[] A;
    static int[] B;
    static int[] C;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        A = new int[N];
        B = new int[N];

        inputArr(A);
        inputArr(B);
        C = Arrays.copyOf(A, N);
        C[0] = 1 - C[0];
        C[1] = 1 - C[1];

        int answerA = flip(A, B);
        int answerC = flip(C, B);
        if (answerC != -1) answerC++;

        if (answerA == -1) System.out.print(answerC);
        else if (answerC == -1) System.out.print(answerA);
        else System.out.print(Math.min(answerA, answerC));
    }

    public static void inputArr(int[] Arr) throws IOException {
        String str = br.readLine();
        for (int i = 0; i < N; i++) {
            Arr[i]= str.charAt(i) - '0';
        }
    }

    public static int flip(int[] A, int[] B) {
        int cnt = 0;

        for (int i = 0; i < N - 1; i++) {
            if (A[i] != B[i]) {
                cnt++;
                A[i] = 1 - A[i];
                A[i + 1] = 1 - A[i + 1];
                if (i != N - 2) A[i + 2] = 1 - A[i + 2];
            }
        }

        return A[N - 1] != B[N - 1] ? -1 : cnt;
    }
}
