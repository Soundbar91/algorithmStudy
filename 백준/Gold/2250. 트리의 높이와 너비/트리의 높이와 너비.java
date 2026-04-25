import java.io.*;
import java.util.*;

public class Main {
    
    static int[] min;
    static int[] max;
    static int[] parent;
    static int count;
    static ArrayList<Integer>[] tree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        // Initialize arrays
        min = new int[n + 1];
        max = new int[n + 1];
        parent = new int[n + 1];
        tree = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) {
            tree[i] = new ArrayList<>();
        }
        Arrays.fill(min, Integer.MAX_VALUE);
        Arrays.fill(parent, -1);
        
        // Read input and build tree
        StringTokenizer st;
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            tree[a].add(b);
            tree[a].add(c);
            if (b != -1) {
                parent[b] = a;
            }
            if (c != -1) {
                parent[c] = a;
            }
        }
        
        // Perform inorder traverse
        for (int i = 1; i <= n; i++) {
            if (parent[i] == -1) {
                dfs(i, 1);
            }
        }
        
        // Find the level with the maximum width
        int idx = 1;
        for (int i = 2; i <= n; i++) {
            if (min[i] <= max[i]) {
                if (max[i] - min[i] + 1 > max[idx] - min[idx] + 1) {
                    idx = i;
                }
            }
        }
        
        System.out.println(idx + " " + (max[idx] - min[idx] + 1));
    }

    static void dfs(int cur, int depth) {
        if (tree[cur].get(0) != -1) {
            dfs(tree[cur].get(0), depth + 1);
        }
        count++;
        min[depth] = Math.min(min[depth], count);
        max[depth] = Math.max(max[depth], count);
        if (tree[cur].get(1) != -1) {
            dfs(tree[cur].get(1), depth + 1);
        }
    }
}
