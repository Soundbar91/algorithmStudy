import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = "";

        while ((input = br.readLine()) != null) {
            List<String> strings = new ArrayList<>();
            Trie trie = new Trie();

            int N = Integer.parseInt(input);
            for (int i = 0; i < N; i++) {
                String word = br.readLine();
                strings.add(word);
                trie.insert(word);
            }

            strings.forEach(trie::press);
            double result = trie.result / (double) N;
            System.out.printf("%.2f%n", result);
        }

        br.close();
    }

    public static class Node {
        Map<Character, Node> children;
        boolean isEnd;

        public Node() {
            children = new HashMap<>();
            isEnd = false;
        }
    }

    public static class Trie {
        Node root;
        int result;

        public Trie() {
            this.root = new Node();
            this.result = 0;
        }

        void insert(String word) {
            Node node = root;

            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                node.children.putIfAbsent(c, new Node());
                node = node.children.get(c);
            }

            node.isEnd = true;
        }

        void press(String string) {
            Node node = root;
            result++;

            for (int i = 0; i < string.length(); i++) {
                char c = string.charAt(i);

                if (node != root) {
                    int size = node.children.size();
                    if (size >= 2) result++;
                    else if (node.isEnd) result++;
                }

                node = node.children.get(c);
            }
        }
    }

}
