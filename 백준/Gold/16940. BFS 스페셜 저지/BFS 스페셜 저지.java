import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static boolean[] visited;
    static int[] inputResult;
    static ArrayList<ArrayList<Integer>> map = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        visited = new boolean[N + 1];
        inputResult = new int[N + 1];

        for (int i = 0; i <= N; i++) map.add(new ArrayList<>());

        for (int i = 0; i < N - 1; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            map.get(x).add(y);
            map.get(y).add(x);
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++){
            inputResult[i] = Integer.parseInt(st.nextToken());
        }

        if (inputResult[1] != 1){
            System.out.print(0);
            System.exit(0);
        }
        
        bfs(1);
    }

    public static void bfs(int startPoint){
        Queue<Integer> queue = new LinkedList<>();
        visited[startPoint] = true;
        queue.add(startPoint);
        int index = 2;

        while (!queue.isEmpty()){
            int node = queue.poll();
            int cnt = 0;

            for (int nextPoint : map.get(node)){
                if (!visited[nextPoint]){
                    visited[nextPoint] = true;
                    cnt++;
                }
            }

            for (int i = index; i < index + cnt; i++){
                if (!visited[inputResult[i]]){
                    System.out.print(0);
                    System.exit(0);
                }
                else {
                    queue.add(inputResult[i]);
                }
            }
            index += cnt;
        }

        System.out.print(1);
        System.exit(0);
    }
}
