import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int[] NArr = new int[N];
        int cnt = 0;
        StringTokenizer st1 = new StringTokenizer(br.readLine());

        while(st1.hasMoreTokens()){
            NArr[cnt] = Integer.parseInt(st1.nextToken());
            cnt++;
        }
        Arrays.sort(NArr);

        int M = Integer.parseInt(br.readLine());
        int[] MArr= new int[M];
        cnt = 0;
        StringTokenizer st2 = new StringTokenizer(br.readLine());

        while(st2.hasMoreTokens()){
            MArr[cnt] = Integer.parseInt(st2.nextToken());
            cnt++;
        }

        for (int j : MArr) {
            sb.append(BinarrySearch(j, NArr, 0, NArr.length - 1)).append('\n');
        }
        System.out.println(sb);
    }

    public static int BinarrySearch(int n, int[] arr, int low, int high){
        if (low > high) return 0;

        int middle = (low + high) / 2;

        if (arr[middle] == n) return 1;
        else if (arr[middle] < n) return BinarrySearch(n, arr, middle + 1, high);
        else return BinarrySearch(n, arr, low, middle - 1);
    }
}