import java.io.*;
import java.util.*;

public class Main {
    public static int pairSize;
    public static String formula;
    public static Stack<Integer> openBracketIndex = new Stack<>();
    public static List<Pair> pairBracketIndex = new ArrayList<>();
    public static Set<String> result = new TreeSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        formula = br.readLine();
        
        solve();
        br.close();
    }

    public static void solve() {
        findBracketIndex();
        makeFormula(0, formula);
        printResult();
    }

    public static void findBracketIndex() {
        char[] charArray = formula.toCharArray();

        for (int i = 0; i < charArray.length; i++) {
            if (charArray[i] == '(') openBracketIndex.push(i);
            else if (charArray[i] == ')') pairBracketIndex.add(new Pair(openBracketIndex.pop(), i));
        }

        pairSize = pairBracketIndex.size();
    }

    public static void makeFormula(int index, String str) {
        if (index == pairSize) result.add(str.replace(" ", ""));
        else {
            Pair pair = pairBracketIndex.get(index);
            StringBuilder sb = new StringBuilder(str);
            sb.setCharAt(pair.left, ' ');
            sb.setCharAt(pair.right, ' ');

            makeFormula(index + 1, sb.toString());
            makeFormula(index + 1, str);
        }
    }

    public static void printResult() {
        result.remove(formula);
        for (String str : result) System.out.println(str);
    }

    public static class Pair {
        int left;
        int right;

        public Pair(int left, int right) {
            this.left = left;
            this.right = right;
        }
    }
}
