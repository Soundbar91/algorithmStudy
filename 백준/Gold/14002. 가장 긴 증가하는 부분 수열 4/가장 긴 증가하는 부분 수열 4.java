import java.io.*;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        Stack<Integer> stack = new Stack<>();

        int n = Integer.parseInt(br.readLine());
        int[] numArr = new int[n + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= n; i++){
            numArr[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[n + 1];

        for (int i = 1; i <= n; i++){
            int numMax = 0;
            for (int j = 0; j < i; j++){
                if(numArr[i] > numArr[j]) {
                    numMax = Math.max(numMax, dp[j]);
                }
            }
            dp[i] = numMax + 1;
        }

        int numMax = Arrays.stream(dp).max().getAsInt();
        sb.append(numMax).append('\n');

        for (int i = n; i >= 1; i--){
            if(dp[i] == numMax){
                stack.push(numArr[i]);
                numMax--;
            }
        }

        while(!stack.empty()){
            sb.append(stack.pop()).append(' ');
        }

        System.out.print(sb);
    }
}
