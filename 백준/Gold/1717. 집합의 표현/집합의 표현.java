import java.io.*;
import java.util.*;

public class Main {

    static int n, m;
    static int[] parents;
    static int[] size;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        parents = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            parents[i] = i;
        }
        size = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            size[i] = 1;
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int order = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if (order == 0) {
                union(a, b);
            } else if (order == 1) {
                int A = find(a);
                int B = find(b);

                sb.append(A == B ? "YES" : "NO").append('\n');
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
