import java.io.*;
import java.util.*;

public class Main {
    static TreeSet<Problem> problemSet = new TreeSet<>();
    static Map<Integer, TreeSet<Problem>> algoTreeSet = new HashMap<>();
    static TreeMap<Integer, Integer> algoMap = new TreeMap<>();
    static TreeMap<Integer, Integer> levelMap = new TreeMap<>();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());

        while (N-- > 0) {
            st = new StringTokenizer(br.readLine());

            int P = Integer.parseInt(st.nextToken());
            int L = Integer.parseInt(st.nextToken());
            int G = Integer.parseInt(st.nextToken());

            addProblem(P, L, G);
        }

        solve();
        bw.flush();
    }

    public static void solve() throws IOException {
        int M = Integer.parseInt(br.readLine());
        int P, L, G, x;

        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());
            String order = st.nextToken();

            switch (order) {
                case "add":
                    P = Integer.parseInt(st.nextToken());
                    L = Integer.parseInt(st.nextToken());
                    G = Integer.parseInt(st.nextToken());
                    addProblem(P, L, G);
                    break;
                case "solved":
                    P = Integer.parseInt(st.nextToken());
                    solveProblem(P);
                    break;
                case "recommend":
                    G = Integer.parseInt(st.nextToken());
                    x = Integer.parseInt(st.nextToken());
                    recommendProblem(G, x);
                    break;
                case "recommend2" :
                    x = Integer.parseInt(st.nextToken());
                    recommendProblem2(x);
                    break;
                default:
                    x = Integer.parseInt(st.nextToken());
                    L = Integer.parseInt(st.nextToken());
                    recommendProblem3(x, L);
            }
        }
    }

    public static void addProblem(int P, int L, int G) {
        Problem problem = new Problem(P, L, G);
        problemSet.add(problem);

        algoTreeSet.computeIfAbsent(G, k -> new TreeSet<>()).add(problem);

        levelMap.put(P, L);
        algoMap.put(P, G);
    }

    public static void solveProblem(int P) {
        int L = levelMap.get(P);
        int G = algoMap.get(P);

        Problem problem = new Problem(P, L, G);
        problemSet.remove(problem);
        if (algoTreeSet.containsKey(G)) {
            algoTreeSet.get(G).remove(problem);
            if (algoTreeSet.get(G).isEmpty()) {
                algoTreeSet.remove(G);
            }
        }
        levelMap.remove(P);
        algoMap.remove(P);
    }

    public static void recommendProblem(int G, int x) throws IOException {
        if (!algoTreeSet.containsKey(G) || algoTreeSet.get(G).isEmpty()) {
            bw.write("-1\n");
            return;
        }
        if (x == 1) bw.write(algoTreeSet.get(G).last().index + "\n");
        else bw.write(algoTreeSet.get(G).first().index + "\n");
    }

    public static void recommendProblem2(int x) throws IOException {
        if (problemSet.isEmpty()) {
            bw.write("-1\n");
            return;
        }
        if (x == 1) bw.write(problemSet.last().index + "\n");
        else bw.write(problemSet.first().index + "\n");
    }

    public static void recommendProblem3(int x, int L) throws IOException {
        if (x == 1) {
            Problem p = problemSet.ceiling(new Problem(0, L, 0));
            if (p == null) bw.write("-1\n");
            else bw.write(p.index + "\n");
        } else {
            Problem p = problemSet.floor(new Problem(0, L, 0));
            if (p == null) bw.write("-1\n");
            else bw.write(p.index + "\n");
        }
    }

    public static class Problem implements Comparable<Problem> {
        int index;
        int level;
        int algo;

        public Problem(int index, int level, int algo) {
            this.index = index;
            this.level = level;
            this.algo = algo;
        }

        @Override
        public int compareTo(Problem o) {
            if (level == o.level) return index - o.index;
            else return level - o.level;
        }
    }
}
