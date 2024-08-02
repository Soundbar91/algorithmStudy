import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static long[] arr, segTree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        arr = new long[N];
        segTree = new long[N * 4];

        for (int i = 0; i < N; i++) {
            arr[i] = Long.parseLong(br.readLine());
        }

        init(1, 0, N - 1);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M + K; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            long c = Long.parseLong(st.nextToken());

            if (a == 1) {
                long diff = c - arr[b - 1];
                arr[b - 1] = c;
                update(1, 0, N - 1, b - 1, diff);
            } else if (a == 2) {
                sb.append(query(1, 0, N - 1, b - 1, (int) c - 1)).append("\n");
            }
        }

        System.out.print(sb);
    }

    public static long init(int node, int start, int end) {
        if (start == end) {
            return segTree[node] = arr[start];
        }

        int mid = (start + end) / 2;
        return segTree[node] = init(node * 2, start, mid) + init(node * 2 + 1, mid + 1, end);
    }

    public static long query(int node, int start, int end, int left, int right) {
        if (left > end || right < start) {
            return 0;
        }

        if (left <= start && end <= right) {
            return segTree[node];
        }

        int mid = (start + end) / 2;
        return query(node * 2, start, mid, left, right) + query(node * 2 + 1, mid + 1, end, left, right);
    }

    public static void update(int node, int start, int end, int index, long diff) {
        if (index < start || index > end) {
            return;
        }

        segTree[node] += diff;

        if (start != end) {
            int mid = (start + end) / 2;
            update(node * 2, start, mid, index, diff);
            update(node * 2 + 1, mid + 1, end, index, diff);
        }
    }
}
