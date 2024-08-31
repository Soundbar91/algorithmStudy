import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

class Main {
    static int memo = -1;
    static String str;
    static int[] alphabet = new int[26];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        str = br.readLine();
        for (char c : str.toCharArray()) alphabet[c - 'A']++;
        if (!valid()) {
            System.out.print("I'm Sorry Hansoo");
            System.exit(0);
        }
        else {
            System.out.print(solve());
            br.close();
        }
    }

    public static String solve() {
        StringBuilder front = new StringBuilder();
        StringBuilder back = new StringBuilder();
        int len = str.length();

        for (int i = 0; i < alphabet.length; i++) {
            while (alphabet[i] >= 2) {
                front.append((char) ('A' + i));
                back.insert(0, (char) ('A' + i));
                alphabet[i] -= 2;
            }
        }

        if (memo != -1) {
            front.append((char) ('A' + memo));
        }

        return front.toString() + back.toString();
    }

    public static boolean valid() {
        int oddCount = 0;

        for (int i = 0; i < alphabet.length; i++) {
            if (alphabet[i] % 2 != 0) {
                oddCount++;
                memo = i;
            }
        }

        return oddCount <= 1;
    }
}
