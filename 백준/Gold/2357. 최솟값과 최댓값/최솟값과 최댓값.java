import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    static int N, M;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        MaxSegTree maxSegTree = new MaxSegTree(N);
        maxSegTree.init(arr, 1, 0, N - 1);
        MinSegTree minSegTree = new MinSegTree(N);
        minSegTree.init(arr, 1, 0, N - 1);

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            int min = minSegTree.query(1, 0, N - 1, a - 1, b - 1);
            int max = maxSegTree.query(1, 0, N - 1, a - 1, b - 1);
            System.out.println(min + " " + max);
        }

        br.close();
    }

    public static class MaxSegTree {
        int[] tree;

        MaxSegTree(int N) {
            tree = new int[N * 4];
        }

        int init(int[] arr, int node, int lo, int hi) {
            if (lo == hi) return tree[node] = arr[lo];

            int mid = lo + (hi - lo) / 2;
            return tree[node] = Math.max(init(arr, node * 2, lo, mid),
                    init(arr, node * 2 + 1, mid + 1, hi));
        }

        int query(int node, int ts, int te, int qs, int qe) {
            if (qs <= ts && te <= qe) return tree[node];
            if (te < qs || qe < ts) return -1;

            int mid = ts + (te - ts) / 2;
            return Math.max(query(node * 2, ts, mid, qs, qe), query(node * 2 + 1, mid + 1, te, qs, qe));
        }
    }

    public static class MinSegTree {
        int[] tree;

        MinSegTree(int N) {
            tree = new int[N * 4];
        }

        int init(int[] arr, int node, int lo, int hi) {
            if (lo == hi) return tree[node] = arr[lo];

            int mid = lo + (hi - lo) / 2;
            return tree[node] = Math.min(init(arr, node * 2, lo, mid),
                    init(arr, node * 2 + 1, mid + 1, hi));
        }

        int query(int node, int ts, int te, int qs, int qe) {
            if (qs <= ts && te <= qe) return tree[node];
            if (te < qs || qe < ts) return 1000000001;

            int mid = ts + (te - ts) / 2;
            return Math.min(query(node * 2, ts, mid, qs, qe), query(node * 2 + 1, mid + 1, te, qs, qe));
        }
    }

}
