import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    static int[][] dist;
    static int[][] prev;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        dist = new int[n + 1][n + 1];
        prev = new int[n + 1][n + 1];

        for (int i = 0; i <= n; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE / 2);
        }

        m = Integer.parseInt(br.readLine());
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            dist[a][b] = Math.min(dist[a][b], c);
            prev[a][b] = b;
        }

        for (int i = 1; i <= n; i++) {
            dist[i][i] = 0;
        }

        solve();
        br.close();
    }

    public static void solve() {
        floydWarshall();
        print();
    }

    public static void floydWarshall() {
        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (dist[i][j] > dist[i][k] + dist[k][j]) {
                        dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                        prev[i][j] = prev[i][k];
                    }
                }
            }
        }
    }

    public static void print() {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (dist[i][j] == Integer.MAX_VALUE / 2) {
                    System.out.print(0 + " ");
                }
                else {
                    System.out.print(dist[i][j] + " ");
                }
            }
            System.out.println();
        }
        
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (dist[i][j] == Integer.MAX_VALUE / 2 || dist[i][j] == 0) {
                    System.out.println(0);
                    continue;
                }

                Stack<Integer> stack = new Stack<>();
                int prevIndex = i;

                while (prevIndex != j) {
                    stack.push(prevIndex);
                    prevIndex = prev[prevIndex][j];
                }
                stack.push(j);

                System.out.print(stack.size() + " ");
                for (Integer index : stack) {
                    System.out.print(index + " ");
                }
                System.out.println();
            }
        }
    }
}
