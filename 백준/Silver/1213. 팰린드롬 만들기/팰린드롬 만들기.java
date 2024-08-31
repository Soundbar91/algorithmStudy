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

        System.out.print(solve());
        br.close();
    }

    public static String solve() {
        StringBuilder sb = new StringBuilder();
        int len = str.length();

        if (len % 2 == 0) {
            for (int i = 0; i < alphabet.length; i++) {
                if (alphabet[i] != 0) {
                    int temp = alphabet[i] / 2;

                    while (alphabet[i] > temp) {
                        sb.append((char)('A' + i));
                        alphabet[i]--;
                    }
                }
            }

            for (int i = alphabet.length - 1; i >= 0; i--) {
                if (alphabet[i] != 0) {
                    while (alphabet[i] > 0) {
                        sb.append((char)('A' + i));
                        alphabet[i]--;
                    }
                }
            }
        }
        else {
            for (int i = 0; i < alphabet.length; i++) {
                if (alphabet[i] != 0) {
                    int temp = alphabet[i] / 2;
                    if (i == memo) temp++;

                    while (alphabet[i] > temp) {
                        sb.append((char)('A' + i));
                        alphabet[i]--;
                    }
                }
            }

            sb.append((char)('A' + memo));
            alphabet[memo]--;

            for (int i = alphabet.length - 1; i >= 0; i--) {
                if (alphabet[i] != 0) {
                    while (alphabet[i] > 0) {
                        sb.append((char)('A' + i));
                        alphabet[i]--;
                    }
                }
            }
        }

        return sb.toString();
    }

    public static boolean valid() {
        int len = str.length();

        if (len % 2 == 0) {
            for (int count : alphabet) {
                if (count % 2 != 0) {
                    return false;
                }
            }
            return true;
        }
        else {
            for (int i = 0; i < alphabet.length; i++) {
                if (alphabet[i] % 2 != 0) {
                    if (memo != -1) return false;
                    memo = i;
                }
            }

            return memo != -1;
        }
    }
}
