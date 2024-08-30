import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

class Main {
    static int N, M, dist;
    static int[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        visited = new int[M][26];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < str.length(); j++) {
                char ch = str.charAt(j);
                visited[j][ch - 'A']++;
            }
        }

        System.out.print(solve() + "\n" + dist);
        br.close();
    }

    public static String solve() {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < M; i++) {
            List<Word> list = new ArrayList<>();

            for (int j = 0; j < 26; j++) {
                if (visited[i][j] != 0) {
                    list.add(new Word('A' + j, visited[i][j]));
                }
            }

            list.sort(null);
            sb.append((char)list.get(0).index);
            for (int j = 1; j < list.size(); j++) {
                dist += list.get(j).count;
            }
        }

        return sb.toString();
    }

    public static class Word implements Comparable<Word> {
        int index;
        int count;

        public Word(int index, int count) {
            this.index = index;
            this.count = count;
        }

        @Override
        public int compareTo(Word o) {
            if (this.count == o.count) return index - o.index;
            return o.count - count;
        }
    }
}
