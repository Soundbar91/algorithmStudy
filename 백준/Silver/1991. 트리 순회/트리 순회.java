import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static Node[] nodes;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        nodes = new Node[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            char name = st.nextToken().charAt(0);
            char left = st.nextToken().charAt(0);
            char right = st.nextToken().charAt(0);

            nodes[name - 'A'] = new Node(name, left, right);
        }

        solve();
        br.close();
    }

    public static void solve() {
        preorder(0);
        System.out.println();
        inorder(0);
        System.out.println();
        postorder(0);
    }

    public static void preorder(int start) {
        System.out.print(nodes[start].name);
        if (nodes[start].left != '.') {
            preorder(nodes[start].left - 'A');
        }
        if (nodes[start].right != '.') {
            preorder(nodes[start].right - 'A');
        }
    }

    public static void inorder(int start) {
        if (nodes[start].left != '.') {
            inorder(nodes[start].left - 'A');
        }
        System.out.print(nodes[start].name);
        if (nodes[start].right != '.') {
            inorder(nodes[start].right - 'A');
        }
    }

    public static void postorder(int start) {
        if (nodes[start].left != '.') {
            postorder(nodes[start].left - 'A');
        }
        if (nodes[start].right != '.') {
            postorder(nodes[start].right - 'A');
        }
        System.out.print(nodes[start].name);
    }

    public static class Node {
        char name;
        char left;
        char right;

        public Node (char name, char left, char right) {
            this.name = name;
            this.left = left;
            this.right = right;
        }
    }
}
