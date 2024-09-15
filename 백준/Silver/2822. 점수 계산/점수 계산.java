import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

class Main {
    static int totalScore = 0;
    static int[] topIndices = new int[5];
    static Score[] scores = new Score[8];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 8; i++) {
            int score = Integer.parseInt(br.readLine());
            scores[i] = new Score(i + 1, score);
        }

        Arrays.sort(scores);

        for (int i = 0; i < 5; i++) {
            totalScore += scores[i].score;
            topIndices[i] = scores[i].index;
        }

        System.out.println(totalScore);
        Arrays.sort(topIndices);
        for (int index : topIndices) {
            System.out.print(index + " ");
        }

        br.close();
    }

    public static class Score implements Comparable<Score> {
        int index;
        int score;

        public Score(int index, int score) {
            this.index = index;
            this.score = score;
        }

        @Override
        public int compareTo(Score o) {
            return o.score - this.score;
        }
    }
}
