import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        if (n == 0) {
            System.out.print(0);
            return ;
        }

        while (n != 1){
            sb.append(n - (Math.round((double)n / -2) * -2));
            n = (int) Math.round((double)n / -2);
        }
        sb.append(n);
        System.out.print(sb.reverse());

    }
}
