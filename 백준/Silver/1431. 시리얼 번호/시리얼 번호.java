import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

class Main {
    static int N;
    static List<Word> words = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        while (N-- > 0) {
            String word = br.readLine();
            int sum = 0;

            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);

                if (c >= '0' && c <= '9') {
                    sum += c - '0';
                }
            }

            words.add(new Word(word, sum));
        }

        words.stream().sorted().forEach((w) -> System.out.println(w.word));
    }

    public static class Word implements Comparable<Word> {
        String word;
        int sum;

        public Word(String word, int sum) {
            this.word = word;
            this.sum = sum;
        }

        @Override
        public int compareTo(Word o) {
            if (word.length() != o.word.length()) return word.length() - o.word.length();
            else if (sum != o.sum) return sum - o.sum;
            else return word.compareTo(o.word);
        }
    }
}
