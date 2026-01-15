import java.io.*;
import java.util.*;

public class Main {

    static int nA, nB;
    static int[] A;
    static int[] B;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        nA = Integer.parseInt(st.nextToken());
        nB = Integer.parseInt(st.nextToken());

        A = new int[nA];
        B = new int[nB];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < nA; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < nB; i++) {
            B[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(A);
        Arrays.sort(B);

        solve();
        br.close();
    }

    public static void solve() {
        StringBuilder sb = new StringBuilder();
        int count = 0;

        for (int i = 0; i < nA; i++) {
            if (!binarySearch(B, A[i])) {
                count++;
                sb.append(A[i]).append(" ");
            }
        }

        if (count == 0) {
            System.out.print(0);
        } else {
            System.out.println(count);
            System.out.print(sb);
        }
    }

    public static boolean binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == target) {
                return true;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return false;
    }
}