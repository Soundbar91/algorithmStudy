import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[][] ability;
    static boolean[] visit;
    static int result = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        ability = new int[N][N];
        visit = new boolean[N];

        for (int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++){
                ability[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0, 0);
        System.out.print(result);
    }

    public static void dfs(int index, int depth){
        if (depth == N / 2){
            int startTeam = calcStart();
            int linkTeam = calcLink();

            result = Math.min(result, Math.abs(startTeam - linkTeam));
        }

        else {
            for (int i = index; i < N; i++){
                if (!visit[i] && ability[0][i] != 0){
                    visit[i] = true;
                    dfs(i + 1, depth + 1);
                    visit[i] = false;
                }
            }
        }
    }

    public static int calcStart(){
        int value = 0;

        for (int i = 0; i < N; i++){
            if (visit[i]){
                for (int j = 0; j < N; j++){
                    if (i == j) continue;
                    if (visit[j]) value += ability[i][j];
                }
            }
        }

        return value;
    }

    public static int calcLink(){
        int value = 0;

        for (int i = 0; i < N; i++){
            if (!visit[i]){
                for (int j = 0; j < N; j++){
                    if (i == j) continue;
                    if (!visit[j]) value += ability[i][j];
                }
            }
        }

        return value;
    }
}
