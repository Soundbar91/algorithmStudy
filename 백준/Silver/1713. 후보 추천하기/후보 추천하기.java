import java.io.*;
import java.util.*;

public class Main {

    static int N, T;
    static Set<Integer> set = new HashSet<>();
    static List<Picture> homePage = new ArrayList<>();
    static Picture[] list = new Picture[101];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        T = Integer.parseInt(br.readLine());

        for (int i = 1; i <= 100; i++) {
            list[i] = new Picture(i, 0, -1);
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < T; i++) {
            int index = Integer.parseInt(st.nextToken());

            if (set.contains(index)) {
                list[index].increaseCount();
            }
            else if (homePage.size() != N) {
                set.add(index);
                homePage.add(list[index]);
                list[index].insertPicture(i);
            } else {
                homePage.sort(null);
                Picture picture = homePage.remove(0);
                set.remove(picture.index);
                list[picture.index].reset();

                set.add(index);
                homePage.add(list[index]);
                list[index].insertPicture(i);
            }
        }

        List<Integer> result = new ArrayList<>(set);
        result.sort(null);

        for (int i = 0; i < result.size(); i++) {
            System.out.print(result.get(i) + " ");
        }

        br.close();
    }

    public static class Picture implements Comparable<Picture> {
        int index;
        int count;
        int createdAt;

        public Picture(int index, int count, int createdAt) {
            this.index = index;
            this.count = count;
            this.createdAt = createdAt;
        }

        public void increaseCount() {
            count++;
        }

        public void reset() {
            count = 0;
            createdAt = -1;
        }

        public void insertPicture(int createdAt) {
            this.count = 1;
            this.createdAt = createdAt;
        }

        @Override
        public int compareTo(Picture o) {
            if (count == o.count) {
                return createdAt - o.createdAt;
            }
            return count - o.count;
        }
    }
}
