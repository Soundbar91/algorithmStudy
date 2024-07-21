import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Main {
    static int n, max, node;
    static boolean[] visited;
    static List<List<Node>> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        visited = new boolean[n + 1];

        for (int i = 0; i <= n; i++) list.add(new ArrayList<>());
        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int mother = Integer.parseInt(st.nextToken());
            int child = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            list.get(mother).add(new Node(child, weight));
            list.get(child).add(new Node(mother, weight));
        }

        visited[1] = true;
        dfs(1, 0);

        visited = new boolean[n + 1];
        visited[node] = true;
        dfs(node, 0);

        System.out.println(max);
        br.close();
    }

    public static void dfs(int start, int sum) {
        if (max < sum) {
            max = sum;
            node = start;
        }
        for (Node node : list.get(start)) {
            if (!visited[node.cur]) {
                visited[node.cur] = true;
                dfs(node.cur, sum + node.weight);
            }
        }
    }

    public static class Node {
        int cur;
        int weight;

        Node(int cur, int weight) {
            this.cur = cur;
            this.weight = weight;
        }
    }
}
