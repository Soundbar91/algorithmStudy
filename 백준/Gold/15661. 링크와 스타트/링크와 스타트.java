import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[][] ability;
    static boolean[] visit;
    static int result = Integer.MAX_VALUE;
    static int teamPeople;

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

        for (int i = 1; i < N; i++){
            teamPeople = i;
            dfs(0, 0);
        }

        System.out.print(result);
    }

    public static void dfs(int index, int depth){
        if (depth == teamPeople){
            calcResult();
        }

        else {
            for (int i = index; i < N; i++){
                if (!visit[i]){
                    visit[i] = true;
                    dfs(i + 1, depth + 1);
                    visit[i] = false;
                }
            }
        }
    }

    public static void calcResult(){
        int startTeam = 0;
        int linkTeam = 0;

        for (int i = 0; i < N - 1; i++) {
            for (int j = i + 1; j < N; j++){
                if (visit[i] && visit[j]){
                    startTeam += (ability[i][j] + ability[j][i]);
                }
                else if(!visit[i] && !visit[j]){
                    linkTeam += (ability[i][j] + ability[j][i]);
                }
            }
        }

        result = Math.min(result, Math.abs(startTeam - linkTeam));

        if (result == 0){
            System.out.print(0);
            System.exit(0);
        }
    }
}
