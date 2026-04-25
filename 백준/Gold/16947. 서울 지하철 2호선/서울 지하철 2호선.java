import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static boolean[] isCycle;
    static ArrayList<ArrayList<Integer>> map = new ArrayList<>();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        for (int i = 0; i <= N; i++) map.add(new ArrayList<>());

        for (int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            map.get(x).add(y);
            map.get(y).add(x);
        }

        for (int i = 1; i <= N; i++){
            isCycle = new boolean[N + 1];
            if (findCircle(i, i, i)) break;
        }

        int[] result = new int[N + 1];
        for (int i = 1; i <= N; i++){
            if(!isCycle[i]) result[i] = bfs(i);
            sb.append(result[i]).append(' ');
        }

        System.out.print(sb);
    }

    public static boolean findCircle(int prevPoint, int nowPoint, int startPoint){
        isCycle[nowPoint] = true;

        for (int i = 0; i < map.get(nowPoint).size(); i++){
            int nextPoint = map.get(nowPoint).get(i);

            if (!isCycle[nextPoint]){
                if (findCircle(nowPoint, nextPoint, startPoint)) return true;
            }
            else if (prevPoint != nextPoint && nextPoint == startPoint){
                return true;
            }
        }
        isCycle[nowPoint] = false;

        return false;
    }

    public static int bfs(int startPoint){
        Queue<int[]> queue = new LinkedList<>();
        boolean[] visited = new boolean[N + 1];
        queue.add(new int[]{startPoint, 0});
        visited[startPoint] = true;

        while (!queue.isEmpty()){
            int[] node = queue.poll();
            int point = node[0];
            int cnt = node[1];

            if (isCycle[point]) return cnt;

            for (int i = 0; i < map.get(point).size(); i++){
                int nextPoint = map.get(point).get(i);

                if (!visited[nextPoint]){
                    visited[nextPoint] = true;
                    queue.add(new int[]{nextPoint, cnt + 1});
                }
            }
        }

        return 0;
    }
}
