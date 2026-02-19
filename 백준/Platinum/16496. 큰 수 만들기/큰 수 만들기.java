import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String[] nums = Arrays.stream(br.readLine().split(" "))
                .toArray(String[]::new);

        System.out.println(solve(nums));
    }

    public static String solve(String[] nums) {
        StringBuilder sb = new StringBuilder();
        Arrays.sort(nums, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return -(o1 + o2).compareTo(o2 + o1);
            }
        });

        for (String i : nums) sb.append(i);
        return sb.charAt(0) == '0' ? "0" : sb.toString();
    }
}