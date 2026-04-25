import java.io.*;

public class Main {
    static char[] str;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        str = br.readLine().toCharArray();
        solve();
    }

    public static void solve() {
        checkA();
        checkB();
        if (!checkResult()) System.out.print(-1);
        else printResult();
    }

    public static void checkA() {
        for (int i = 0; i < str.length - 3;) {
            if (checkDot(i, i + 3)) {
                flipString(i, i + 3, 'A');
                i += 4;
            }
            else i++;
        }
    }

    public static void checkB() {
        for (int i = 0; i < str.length - 1;) {
            if (checkDot(i, i + 1)) {
                flipString(i, i + 1, 'B');
                i += 2;
            }
            else i++;
        }
    }

    public static boolean checkDot(int lo, int hi) {
        for (int i = lo; i <= hi; i++) {
            if (str[i] != 'X') return false;
        }
        return true;
    }

    public static void flipString(int lo, int hi, char c) {
        for (int i = lo; i <= hi; i++) {
            str[i] = c;
        }
    }

    public static boolean checkResult() {
        for (char c : str) {
            if (c == 'X') return false;
        }
        return true;
    }

    public static void printResult() {
        for (char c : str) System.out.print(c);
    }
}
