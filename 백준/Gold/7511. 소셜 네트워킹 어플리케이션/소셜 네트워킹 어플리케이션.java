import java.io.*;
import java.util.*;

public class Main {

    static int T, n, k, m;
    static int[] parents;
    static int[] size;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        T = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= T; i++) {
            sb.append("Scenario ").append(i).append(":").append('\n');
            n = Integer.parseInt(br.readLine());
            k = Integer.parseInt(br.readLine());

            parents = new int[n];
            for (int j = 0; j < n; j++) {
                parents[j] = j;
            }
            size = new int[n];
            for (int j = 0; j < n; j++) {
                size[j] = 1;
            }

            for (int j = 0; j < k; j++) {
                st = new StringTokenizer(br.readLine());

                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                union(a, b);
            }

            m = Integer.parseInt(br.readLine());
            for (int j = 0; j < m; j++) {
                st = new StringTokenizer(br.readLine());
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());

                int U = find(u);
                int V = find(v);

                sb.append(U == V ? 1 : 0).append('\n');
            }

            sb.append('\n');
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
