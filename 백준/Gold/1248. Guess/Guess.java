import java.io.*;

public class Main {
    static int n;
    static char[][] map;
    static int[] node;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        String str = br.readLine();
        int strIndex = 0;
        map = new char[n][n];
        node = new int[n];

        for (int i = 0; i < n; i++){
            for (int j = i; j < n; j++){
                map[i][j] = str.charAt(strIndex++);
            }
        }

        dfs(0);
    }

    public static void dfs(int depth){
        if (depth == n){
            for (int i : node){
                System.out.print(i + " ");
            }
            System.exit(0);
        }

        else {
            for (int i = -10; i <= 10; i++){
                node[depth] = i;
                if (valid(depth + 1)){
                    dfs(depth + 1);
                }
            }
        }
    }

    public static boolean valid(int end){
        for (int i = 0; i < end; i++){
            int sum = 0;
            for (int j = i; j < end; j++){
                sum += node[j];
                if (map[i][j] != (sum == 0 ? '0' : (sum > 0) ? '+' : '-')){
                    return false;
                }
            }
        }

        return true;
    }
}
