import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    static int N, M, K;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        SegTree segTree = new SegTree(N);
        segTree.init(arr, 1, 0, N - 1);

        for (int i = 0; i < M + K; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            if (a == 1) {
                segTree.update(1, 0, N - 1, b - 1, c);
                arr[b - 1] = c;
            }
            else {
                System.out.println(segTree.query(1, 0, N - 1, b - 1, c - 1));
            }
        }

        br.close();
    }

    public static class SegTree {
        long[] tree;

        SegTree(int N) {
            tree = new long[N * 4];
        }

        long init(int[] arr, int node, int lo, int hi) {
            if (lo == hi) return tree[node] = arr[lo];

            int mid = lo + (hi - lo) / 2;
            return tree[node] = (init(arr, node * 2, lo, mid) * init(arr, node * 2 + 1, mid + 1, hi))
                    % 1000000007;
        }

        long query(int node, int ts, int te, int qs, int qe) {
            if (qs <= ts && te <= qe) return tree[node];
            if (te < qs || qe < ts) return 1;

            int mid = ts + (te - ts) / 2;
            return (query(node * 2, ts, mid, qs, qe) * query(node * 2 + 1, mid + 1, te, qs, qe))
                    % 1000000007;
        }

        long update(int node, int ts, int te, int modifyIndex, int modifyValue) {
            if (ts > modifyIndex || te < modifyIndex) return tree[node];
            if (ts == te) return tree[node] = modifyValue;

            int mid = ts + (te - ts) / 2;
            return tree[node] = (update(node * 2, ts, mid, modifyIndex, modifyValue) *
                    update(node * 2 + 1, mid + 1, te, modifyIndex, modifyValue)) % 1000000007;
        }
    }

}
