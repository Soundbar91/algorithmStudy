import java.io.*;

public class Main {
    static int n;
    static boolean[] visit;
    static int[] node;
    static int[] numArr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(br.readLine());
        visit = new boolean[n];
        node = new int[n];
        numArr = new int[n];

        for (int i = 0; i < n; i++){
            numArr[i] = i + 1;
        }

        dfs(0);
    }

    public static void dfs(int depth){
        if (depth == n){
            for (int i : node){
                System.out.print(i + " ");
            }
            System.out.println();
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
