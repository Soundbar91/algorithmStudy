import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

class Main {
    static int[] parents;
    static int[] size;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            int F = Integer.parseInt(br.readLine());

            parents = new int[200001];
            for (int i = 1; i <= 200000; i++) parents[i] = i;

            size = new int[200001];
            Arrays.fill(size, 1);

            Map<String, Integer> map = new HashMap<>();

            while (F-- > 0) {
                st = new StringTokenizer(br.readLine());

                String f1 = st.nextToken();
                int f1Index = map.computeIfAbsent(f1, key -> map.size());

                String f2 = st.nextToken();
                int f2Index = map.computeIfAbsent(f2, key -> map.size());

                System.out.println(union(f1Index, f2Index));
            }
        }

        br.close();
    }

    public static int find(int x) {
        if (parents[x] == x) return x;
        else return parents[x] = find(parents[x]);
    }

    public static int union(int x, int y) {
        int X = find(x);
        int Y = find(y);

        if (X == Y) return size[X];

        if (size[X] >= size[Y]) {
            parents[Y] = X;
            size[X] += size[Y];
            size[Y] = 1;
            return size[X];
        }
        else {
            parents[X] = Y;
            size[Y] += size[X];
            size[X] = 1;
            return size[Y];
        }
    }
}
