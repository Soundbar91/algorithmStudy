import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int M = Integer.parseInt(br.readLine());
        int n = 0;
        int bitMask = 0;

        while (M-- > 0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String str = st.nextToken();
            if (st.hasMoreTokens()) n = Integer.parseInt(st.nextToken());

            if (str.equals("add")) bitMask |= (1 << n);
            else if (str.equals("remove")) bitMask &= ~(1 << n);
            else if (str.equals("check")) sb.append((bitMask & (1 << n)) != 0 ? 1 : 0).append('\n');
            else if (str.equals("toggle")) bitMask ^= (1 << n);
            else if (str.equals("all")) bitMask = (1 << 21) - 1;
            else bitMask = 0;
        }

        System.out.print(sb);
    }
}
