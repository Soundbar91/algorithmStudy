import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    static int n, m;
    static int[] parents;
    static int[] size;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        parents = new int[n + 1];
        for (int i = 0; i <= n; i++) parents[i] = i;

        size = new int[n + 1];

        while (m-- > 0) {
            st = new StringTokenizer(br.readLine());

            int order = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            if (order == 0) union(x, y);
            else {
                int X = find(x);
                int Y = find(y);

                System.out.println(X == Y ? "YES" : "NO");
            }
        }

        br.close();
    }

    public static int find(int x) {
        if (parents[x] == x) return x;
        else return parents[x] = find(parents[x]);
    }

    public static void union(int x, int y) {
        int X = find(x);
        int Y = find(y);

        if (X == Y) return;

        if (size[X] >= size[Y]) parents[Y] = X;
        else parents[X] = Y;

        if (size[X] == size[Y]) size[Y] = size[X] + 1;
    }
}
