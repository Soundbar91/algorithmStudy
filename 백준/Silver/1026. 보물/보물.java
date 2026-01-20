import java.io.*;
import java.util.*;

public class Main {

    static int N, S;
    static Number[] numbers;
    static int[] A;
    static int[] B;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        A = new int[N];
        B = new int[N];
        numbers = new Number[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            B[i] = Integer.parseInt(st.nextToken());
            numbers[i] = new Number(i, B[i]);
        }

        Arrays.sort(A);
        Arrays.sort(numbers);

        for (int i = 0; i < N; i++) {
            S += (A[i] * B[numbers[i].index]);
        }

        System.out.print(S);
        br.close();
    }

    public static class Number implements Comparable<Number> {
        int index;
        int value;

        public Number(int index, int value) {
            this.index = index;
            this.value = value;
        }

        @Override
        public int compareTo(Number o) {
            return o.value - this.value;
        }
    }
}
