import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int M;
    static boolean[] visit;
    static int result;
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        visit = new boolean[N + 1];
        for (int i = 0; i <= N; i++) graph.add(new ArrayList<>());

        while (M-- > 0){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            graph.get(x).add(y);
            graph.get(y).add(x);
        }

        for (int i = 1; i <= N; i++){
            if (!visit[i]){
                dfs(i);
                result++;
            }
        }

        System.out.print(result);
    }

    public static void dfs(int startPoint){
        visit[startPoint] = true;

        for (int i = 0; i < graph.get(startPoint).size(); i++){
            int nextPoint = graph.get(startPoint).get(i);

            if (!visit[nextPoint]){
                visit[nextPoint] = true;
                dfs(nextPoint);
            }
        }
    }
}
