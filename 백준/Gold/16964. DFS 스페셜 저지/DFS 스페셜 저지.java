import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int index = 2;
    static boolean[] visited;
    static int[] result;
    static ArrayList<ArrayList<Integer>> map = new ArrayList<>();
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        visited = new boolean[N + 1];
        result = new int[N + 1];

        for (int i = 0; i <= N; i++) map.add(new ArrayList<>());

        for (int i = 0; i < N - 1; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            map.get(x).add(y);
            map.get(y).add(x);
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) result[i] = Integer.parseInt(st.nextToken());

        if (result[1] != 1) {
            System.out.print(0);
            System.exit(0);
        }

        dfs(1);
        System.out.print(1);
    }

    public static void dfs(int startPoint){
        HashSet<Integer> set = new HashSet<>();

        if (visited[startPoint]) return ;
        visited[startPoint] = true;

        for (int nextPoint : map.get(startPoint)){
            if (!visited[nextPoint]) set.add(nextPoint);
        }

        if (set.isEmpty()) return ;

        if (set.contains(result[index])) dfs(result[index++]);
        else {
            System.out.print(0);
            System.exit(0);
        }
    }
}
