import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int N, M, result = 98654321;
    static int[] selectChickenHouses;
    static boolean[] visited;
    static List<int[]> chickenHouses = new ArrayList<>();
    static List<int[]> houses = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int input = Integer.parseInt(st.nextToken());
                if (input == 1) {
                    houses.add(new int[] {i, j});
                } else if (input == 2) {
                    chickenHouses.add(new int[] {i, j});
                }
            }
        }

        selectChickenHouses = new int[M];
        visited = new boolean[chickenHouses.size()];

        solve(0, 0);
        System.out.print(result);
        br.close();
    }

    public static void solve(int start, int depth) {
        if (depth == M) {
            calc();
        } else {
            for (int index = start; index < chickenHouses.size(); index++) {
                if (!visited[index]) {
                    visited[index] = true;
                    selectChickenHouses[depth] = index;
                    solve(index + 1, depth + 1);
                    visited[index] = false;
                }
            }
        }
    }

    public static void calc() {
        int dist = 0;

        for (int i = 0; i < houses.size(); i++) {
            int[] house = houses.get(i);
            int tmpDist = 987654321;

            for (int j = 0; j < M; j++) {
                int[] selectChickenHouse = chickenHouses.get(selectChickenHouses[j]);
                int calcDist = (Math.abs(house[0] - selectChickenHouse[0]) + Math.abs(house[1] - selectChickenHouse[1]));
                tmpDist = Math.min(tmpDist, calcDist);
            }

            dist += tmpDist;
        }

        result = Math.min(dist, result);
    }
}
