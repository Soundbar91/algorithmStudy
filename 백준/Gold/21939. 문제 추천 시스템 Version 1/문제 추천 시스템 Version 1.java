import java.io.*;
import java.util.*;

public class Main {
    static TreeMap<Integer, TreeSet<Integer>> map = new TreeMap<>();
    static Map<Integer, Integer> problemMap = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        while (N-- > 0) {
            st = new StringTokenizer(br.readLine());
            int problemNumber = Integer.parseInt(st.nextToken());
            int difficulty = Integer.parseInt(st.nextToken());

            addProblem(problemNumber, difficulty);
        }

        int M = Integer.parseInt(br.readLine());

        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());
            String order = st.nextToken();

            if (order.equals("add")) {
                int problemNumber = Integer.parseInt(st.nextToken());
                int difficulty = Integer.parseInt(st.nextToken());

                addProblem(problemNumber, difficulty);
            }
            else if (order.equals("recommend")) {
                int parameter = Integer.parseInt(st.nextToken());

                if (parameter == 1) {
                    System.out.println(map.lastEntry().getValue().last());
                }
                else {
                    System.out.println(map.firstEntry().getValue().first());
                }
            }
            else {
                int problemNumber = Integer.parseInt(st.nextToken());
                int difficulty = problemMap.get(problemNumber);

                TreeSet<Integer> treeSet = map.get(difficulty);
                treeSet.remove(problemNumber);

                problemMap.remove(problemNumber);
                if (treeSet.isEmpty()) map.remove(difficulty);
                else map.put(difficulty, treeSet);
            }
        }

        br.close();
    }

    public static void addProblem(int problemNumber, int difficulty) {
        TreeSet<Integer> queue = map.getOrDefault(difficulty, new TreeSet<>());
        queue.add(problemNumber);

        problemMap.put(problemNumber, difficulty);
        map.put(difficulty, queue);
    }
}
