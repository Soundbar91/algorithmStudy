import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static boolean[] visit;
    static int[][] wight;
    static int[] node;
    static int result = Integer.MAX_VALUE;
    static int start;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        visit = new boolean[n];
        wight = new int[n][n];
        node = new int[n];

        for (int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++){
                wight[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (start = 0; start < n; start++){
            visit[start] = true;
            dfs(start, 0);
            visit[start] = false;
        }

        System.out.print(result);

    }

    public static void dfs(int index, int depth){
        if (depth == n - 1){
            int value = 0;
            for (int i : node){
                value += i;
            }
            if (wight[index][start] == 0) return;
            value += wight[index][start];
            result = Math.min(result, value);
        }

        else{
            for (int i = 0; i < n; i++){
                if (!visit[i] && wight[index][i] != 0){
                    visit[i] = true;
                    node[i] = wight[index][i];
                    dfs(i, depth + 1);
                    visit[i] = false;
                }
            }
        }
    }
}
