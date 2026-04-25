import java.io.*;
import java.util.*;

public class Main {
    static int N;

    public static void main(String[] args) throws IOException {
        String[] solve = solve();
        System.out.print(solve[0] + "\n" + solve[1]);
    }

    public static String[] solve() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Integer> map = new HashMap<>();
        List<String> list = new ArrayList<>();
        N = Integer.parseInt(br.readLine());
        String[] result = new String[2];

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            map.put(s, i);
            list.add(s);
        }

        int temp = 0;
        int n1 = 0, n2 = 0;

        for (int i = 0; i < N - 1; i++) {
            String str1 = list.get(i);
            for (int j = i + 1; j < N; j++) {
                String str2 = list.get(j);
                if (!str1.equals(str2)) {
                    int check = check(str1, str2);
                    if (temp < check) {
                        temp = check;
                        n1 = i;
                        n2 = j;
                    }
                }
            }
        }

        result[0] = list.get(n1);
        result[1] = list.get(n2);

        return result;
    }

    public static int check(String str1, String str2) {
        int count = 0;

        for (int i = 0; i < Math.min(str1.length(), str2.length()); i++) {
            if (str1.charAt(i) == str2.charAt(i)) count++;
            else break;
        }

        return count;
    }

    public static class Word {
        String string;
        int num;

        public Word(String string, int num) {
            this.string = string;
            this.num = num;
        }
    }
}
