import java.io.*;
import java.util.*;

public class Main {
	static int N, M, result;
	static Trie trie = new Trie();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		while (N-- > 0) {
			String str = br.readLine();
			trie.insert(str);
		}
		
		while (M-- > 0) {
			String str = br.readLine();
			if (trie.contains(str)) result++;
		}
		
		System.out.print(result);
		br.close();
	}
	
	public static class Node {
		Map<Character, Node> child;
		boolean isLastChar;
		
		public Node() {
			child = new HashMap<Character, Node>();
			isLastChar = false;
		}
	}
	
	public static class Trie {
		Node root;
		
		public Trie() {
			root = new Node();
		}
		
		void insert(String word) {
			Node node = root;
			
			for (int i = 0; i < word.length(); i++) {
				if(!node.child.containsKey(word.charAt(i))) node.child.put(word.charAt(i), new Node());
				node = node.child.get(word.charAt(i));
			}
			
			node.isLastChar = true;
		}
		
		boolean contains(String word) {
			Node node = root;
			
			for (int i = 0; i < word.length(); i++) {
				char c = word.charAt(i);
				Node next = node.child.get(c);
				
				if (next == null) return false;
				node = next;
			}
			return node.isLastChar;
		}
	}
	
}