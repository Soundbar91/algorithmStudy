import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static boolean[] visit;
    static int[] node;
    static int[] numArr;
    static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        node = new int[n];
        visit = new boolean[n];
        numArr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++){
            numArr[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0);
        System.out.print(result);

    }

    public static void dfs(int depth){
        if (depth == n){
            int value = 0;
            for (int i = 0; i < n - 1; i++){
                value += Math.abs(node[i] - node[i + 1]);
            }
            result = Math.max(result, value);
        }

        else {
            for (int i = 0; i < n; i++){
                if(!visit[i]){
                    visit[i] = true;
                    node[depth] = numArr[i];
                    dfs(depth + 1);
                    visit[i] = false;
                }
            }
        }
    }
}
