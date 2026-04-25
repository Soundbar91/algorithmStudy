import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static int M;
    static int R;
    static int depth = 1;
    static int[] node;
    static Queue<Integer> queue = new LinkedList<>();
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        node = new int[N + 1];

        for (int i = 0; i <= N; i++) graph.add(new ArrayList<>());

        while (M-- > 0){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            graph.get(x).add(y);
            graph.get(y).add(x);
        }

        for (int i = 1; i < graph.size(); i++) graph.get(i).sort(Collections.reverseOrder());

        bfs(R);

        for (int i = 1; i < node.length; i++) System.out.println(node[i]);
    }

    public static void bfs(int startPoint){
        node[startPoint] = depth++;
        queue.addAll(graph.get(startPoint));

        while (!queue.isEmpty()){
            int point = queue.poll();

            if (node[point] != 0) continue;

            node[point] = depth++;

            for (int i = 0; i < graph.get(point).size(); i++){
                int nextPoint = graph.get(point).get(i);
                if (node[nextPoint] == 0) queue.add(nextPoint);
            }
        }
    }
}
