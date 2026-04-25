import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        String str = "";

        while ((str = br.readLine()) != null && !str.isEmpty()){
            StringTokenizer st = new StringTokenizer(str, "\n");
            String str1 = st.nextToken();
            int smallLetter = 0;
            int bigLetter = 0;
            int num = 0;
            int blank = 0;

            for (char ch : str1.toCharArray()){
                if (ch - '0' >= 0 && ch - '0' <= 9) num++;
                else if (ch - 'a' >= 0 && ch - 'z' <= 25) smallLetter++;
                else if (ch - 'A' >= 0 && ch - 'Z' <= 25) bigLetter++;
                else blank++;
            }

            sb.append(String.valueOf(smallLetter)).append(' ');
            sb.append(String.valueOf(bigLetter)).append(' ');
            sb.append(String.valueOf(num)).append(' ');
            sb.append(String.valueOf(blank)).append('\n');
        }
        System.out.println(sb);
    }
}
