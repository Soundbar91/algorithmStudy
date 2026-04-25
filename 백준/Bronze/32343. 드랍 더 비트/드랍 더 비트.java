import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    static int N, a, b, result;
    static int[] A, B;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());

        A = new int[N];
        B = new int[N];

        setA(0, 0);
        System.out.print(result);
    }

    public static void setA(int depth, int count) {
        if (count == a) setB(0, 0);
        if (depth >= N) return;
        else {
            A[depth] = 1;
            setA(depth + 1, count + 1);
            A[depth] = 0;
            setA(depth + 1, count);
        }
    }

    public static void setB(int depth, int count) {
        if (count == b) calc();
        if (depth >= N) return;
        else {
            B[depth] = 1;
            setB(depth + 1, count + 1);
            B[depth] = 0;
            setB(depth + 1, count);
        }
    }

    public static void calc() {
        int sum = 0, weight = 1;

        for (int i = 0; i < N; i++) {
            if (A[i] != B[i]) sum += weight;
            weight *= 2;
        }

        result = Math.max(result, sum);
    }
}
