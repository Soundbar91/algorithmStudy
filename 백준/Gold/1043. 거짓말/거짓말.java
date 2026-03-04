import java.io.*;
import java.util.*;

public class Main {

    static int N, M;
    static int[] parents;
    static List<List<Integer>> parties = new ArrayList<>();
    static Set<Integer> knowTruePeoples = new HashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        parents = new int[N + 1];
        for (int i = 0; i <= N; i++) {
            parents[i] = i;
        }
        for (int i = 0; i < M; i++) {
            parties.add(new ArrayList<>());
        }

        st = new StringTokenizer(br.readLine());
        int knowTruePeopleCount = Integer.parseInt(st.nextToken());
        for (int i = 0; i < knowTruePeopleCount; i++) {
            knowTruePeoples.add(Integer.parseInt(st.nextToken()));
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int joinPartyPeopleCount = Integer.parseInt(st.nextToken());
            int temp1 = Integer.parseInt(st.nextToken());
            parties.get(i).add(temp1);
            for (int j = 1; j < joinPartyPeopleCount; j++) {
                int temp2 = Integer.parseInt(st.nextToken());
                union(temp1, temp2);
                parties.get(i).add(temp2);
            }
        }

        int count = 0;
        for (int i = 0; i < M; i++) {
            boolean flag = false;
            for (int peopleNum : parties.get(i)) {
                if (knowTruePeoples.contains(find(peopleNum))) {
                    flag = true;
                    break;
                }
            }

            if (!flag) {
                count++;
            }
        }

        System.out.print(count);
        br.close();
    }

    public static int find(int x) {
        if (parents[x] == x) return x;
        else return parents[x] = find(parents[x]);
    }

    public static void union(int x, int y) {
        int X = find(x);
        int Y = find(y);

        if (knowTruePeoples.contains(Y)) {
            int temp = X;
            X = Y;
            Y = temp;
        }

        parents[Y] = X;
    }
}
