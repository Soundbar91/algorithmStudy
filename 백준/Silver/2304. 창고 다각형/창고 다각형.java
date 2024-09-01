import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Main {
    static int N, maxIndex, maxHeight;
    static List<Box> boxes = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            int index = Integer.parseInt(st.nextToken());
            int height = Integer.parseInt(st.nextToken());

            boxes.add(new Box(index, height));
            if (height > maxHeight) {
                maxIndex = index;
                maxHeight = height;
            }
        }

        System.out.print(solve());
        br.close();
    }

    public static int solve() {
        int result = 0;
        int len = boxes.size();
        boxes.sort(null);

        Box prev = boxes.get(0);
        if (prev.index != maxIndex) {
            for (int i = 1; i < boxes.size(); i++) {
                Box next = boxes.get(i);

                if (next.height >= prev.height) {
                    result += (next.index - prev.index) * prev.height;
                    prev = next;
                }
                if (next.index == maxIndex) break;
            }
        }

        prev = boxes.get(len - 1);
        if (prev.index != maxIndex) {
            for (int i = len - 2; i >= 0; i--) {
                Box next = boxes.get(i);

                if (next.height >= prev.height) {
                    result += (prev.index - next.index) * prev.height;
                    prev = next;
                }
                if (next.index == maxIndex) break;
            }
        }

        return result + maxHeight;
    }

    public static class Box implements Comparable<Box> {
        int index;
        int height;

        public Box(int index, int height) {
            this.index = index;
            this.height = height;
        }

        @Override
        public int compareTo(Box o) {
            return index - o.index;
        }
    }
}
