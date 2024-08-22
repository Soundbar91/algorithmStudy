import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

class Main {
    static int N;
    static Trie trie = new Trie();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        while (N-- > 0) {
            st = new StringTokenizer(br.readLine());

            int count = Integer.parseInt(st.nextToken());
            String[] words = new String[count];

            for (int i = 0; i < count; i++) {
                words[i] = st.nextToken();
            }

            trie.insert(words);
        }

        trie.search(trie.root, 0);
        System.out.print(sb);
        br.close();
    }

    public static class TrieNode {
        TreeMap<String, TrieNode> children;
        boolean isEnd;

        public TrieNode() {
            children = new TreeMap<>();
            isEnd = false;
        }
    }

    public static class Trie {
        TrieNode root;

        public Trie() {
            root = new TrieNode();
        }

        void insert(String[] words) {
            TrieNode cur = root;

            for (String word : words) {
                cur.children.putIfAbsent(word, new TrieNode());
                cur = cur.children.get(word);
                cur.isEnd = true;
            }
        }

        void search(TrieNode node, int depth) {
            TreeMap<String, TrieNode> children = node.children;

            for (Map.Entry<String, TrieNode> entry : children.entrySet()) {
                String key = entry.getKey();
                TrieNode child = entry.getValue();

                sb.append("-".repeat(depth)).append(key).append('\n');
                search(child, depth + 2);
            }
        }

    }

}
