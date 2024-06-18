import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int[] weights = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt).toArray();

            System.out.println(solve(M, weights));
        }

        br.close();
    }

    public static int solve(int M, int[] weights) {
        Queue<Document> queue = new LinkedList<>();
        addDocument(queue, weights);
        int result = 0;

        while (true) {
            Document cur = queue.poll();
            boolean update = false;

            for (Document next : queue) {
                if (next.weight > cur.weight) {
                    update = true;
                    break;
                }
            }

            if (!update) {
                result++;
                if (cur.index == M) return result;
            }
            else queue.add(cur);
        }
    }

    public static void addDocument(Queue<Document> queue, int[] weights) {
        for (int i = 0; i < weights.length; i++) queue.add(new Document(i, weights[i]));
    }

    public static class Document {
        int index;
        int weight;

        public Document(int index, int weight) {
            this.index = index;
            this.weight = weight;
        }
    }
}
