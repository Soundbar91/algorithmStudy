import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int k;
    static int[] node;
    static int[] numArr;
    static boolean[] visit;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true){
            StringTokenizer st = new StringTokenizer(br.readLine());
            k = Integer.parseInt(st.nextToken());
            if (k == 0) break;
            numArr = new int[k];
            node = new int[6];
            visit = new boolean[k];

            for (int i = 0; i < k; i++){
                numArr[i] = Integer.parseInt(st.nextToken());
            }

            dfs(0, 0);
            sb.append('\n');
        }
        System.out.print(sb);
    }

    public static void dfs(int index, int depth){
        if (depth == 6){
            Arrays.sort(node);
            for (int i : node){
                sb.append(i).append(' ');
            }
            sb.append('\n');
        }

        else {
            for (int i = index; i < k; i++){
                if(!visit[i]){
                    visit[i] = true;
                    node[depth] = numArr[i];
                    dfs(i,depth + 1);
                    visit[i] = false;
                }
            }
        }
    }
}
