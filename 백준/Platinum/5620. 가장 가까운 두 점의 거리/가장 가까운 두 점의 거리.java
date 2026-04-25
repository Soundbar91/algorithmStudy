import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

import static java.lang.Math.*;
import static java.util.Collections.*;
import static java.util.Comparator.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        ArrayList<int[]> list = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            list.add(new int[]{x, y});
        }
        sort(list, comparingInt(arr -> arr[0]));

        System.out.println(closestPair(list, 0, N - 1));
        br.close();
    }

    public static int closestPair(ArrayList<int[]> list, int lo, int hi) {
        if (hi - lo + 1 <= 3) {
            return bruteForce(list, lo, hi);
        }
        else {
            int mid = lo + (hi - lo) / 2;

            int left = closestPair(list, lo, mid);
            int right = closestPair(list, mid + 1, hi);
            int d = min(left, right);

            ArrayList<int[]> band = new ArrayList<>();
            for (int i = lo; i <= hi; i++) {
                int dist = list.get(mid)[0] - list.get(i)[0];

                if (dist * dist < d) band.add(list.get(i));
            }

            sort(band, comparingInt(arr -> arr[1]));

            for (int i = 0; i < band.size() - 1; i++) {
                for (int j = i + 1; j < band.size(); j++) {
                    int dist = band.get(j)[1] - band.get(i)[1];

                    if (dist * dist < d) d = min(d, calcDist(band.get(i), band.get(j)));
                    else break;
                }
            }

            return d;
        }
    }


    public static int bruteForce(ArrayList<int[]> list, int lo, int hi) {
        int min = Integer.MAX_VALUE;

        for (int i = lo; i < hi; i++) {
            for (int j = i + 1; j <= hi; j++) {
                min = min(min, calcDist(list.get(i), list.get(j)));
            }
        }

        return min;
    }

    public static int calcDist(int[] p, int[] q) {
        return (p[0] - q[0]) * (p[0] - q[0]) + (p[1] - q[1]) * (p[1] - q[1]);
    }
}