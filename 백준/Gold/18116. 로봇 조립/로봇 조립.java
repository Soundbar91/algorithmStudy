import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int[] parents;
    static int[] size;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        parents = new int[1000001];
        for (int i = 0; i < 1000001; i++) {
            parents[i] = i;
        }
        size = new int[1000001];
        for (int i = 0; i < 1000001; i++) {
            size[i] = 1;
        }

        while (N-- > 0) {
            st = new StringTokenizer(br.readLine());
            char order = st.nextToken().charAt(0);

            if (order =='I') {
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                union(a, b);
            } else if (order == 'Q') {
                int c = Integer.parseInt(st.nextToken());
                sb.append(size[find(c)]).append('\n');
            }
        }

        System.out.print(sb);
        br.close();
    }

    public static void union(int a, int b) {
        int A = find(a);
        int B = find(b);

        if (A == B) {
            return;
        }

        if (size[A] <= size[B]) {
            parents[A] = B;
            size[B] += size[A];
        } else {
            parents[B] = A;
            size[A] += size[B];
        }
    }

    public static int find(int x) {
        if (x == parents[x]) {
            return x;
        } else {
            return parents[x] = find(parents[x]);
        }
    }
}
