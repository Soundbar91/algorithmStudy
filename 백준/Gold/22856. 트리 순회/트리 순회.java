import java.io.*;
import java.util.*;

public class Main {

    static int N, result, lastNode;
    static Node[] nodes;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        nodes = new Node[N + 1];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            nodes[a] = new Node(b, c);
        }

        findLastNode(1);
        inOrder(1);

        System.out.println(result);
        br.close();
    }

    public static void findLastNode(int cur) {
        Node node = nodes[cur];
        if (node.left != -1) {
            findLastNode(node.left);
        }
        lastNode = cur;
        if (node.right != -1) {
            findLastNode(node.right);
        }
    }

    public static void inOrder(int current) {
        Node node = nodes[current];
        if (node.left != -1) {
            result++;
            inOrder(node.left);
        }
        if (current == lastNode) {
            System.out.print(result);
            System.exit(0);
        }
        if (node.right != -1) {
            result++;
            inOrder(node.right);
        }
        result++;
    }

    static class Node {
        int left;
        int right;

        public Node(int left, int right) {
            this.left = left;
            this.right = right;
        }
    }
}
