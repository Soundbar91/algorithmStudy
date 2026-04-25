import java.io.*;
import java.util.StringTokenizer;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int[] numArr = new int[m];

        st = new StringTokenizer(br.readLine());

        int n = st.countTokens();
        while (n-- > 0){
            numArr[n] = Integer.parseInt(st.nextToken());
        }

        int ten = 0;
        for (int i = 0; i < numArr.length; i++){
            ten += (int) (numArr[i] * Math.pow(A, i));
        }

        Stack<Integer> stack = new Stack<>();

        while (ten >= B){
            stack.push(ten % B);
            ten /= B;
        }
        stack.push(ten);

        while(!stack.empty()){
            sb.append(String.valueOf(stack.pop())).append(' ');
        }
        System.out.print(sb);
    }
}
