import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int M;
    static int R;
    static int depth = 1;
    static boolean[] visit;
    static int[] node;
    static Queue<Integer> queue = new LinkedList<>();
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        visit = new boolean[N + 1];
        node = new int[N + 1];

        for (int i = 0; i <= N; i++) graph.add(new ArrayList<>());

        while (M-- > 0){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            graph.get(x).add(y);
            graph.get(y).add(x);
        }

        for (int i = 1; i < graph.size(); i++) Collections.sort(graph.get(i));

        visit[R] = true;
        node[R] = depth++;
        queue.addAll(graph.get(R));

        while (!queue.isEmpty()){
            int point = queue.poll();

            if (!visit[point]) {
                visit[point] = true;
                node[point] = depth++;

                for (int i = 0; i < graph.get(point).size(); i++){
                    int value = graph.get(point).get(i);
                    if (!visit[value]) queue.add(value);
                }
            }
        }

        for (int i = 1; i < node.length; i++) sb.append(node[i]).append('\n');
        System.out.print(sb);
    }
}
