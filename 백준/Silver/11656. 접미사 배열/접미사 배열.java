import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str = br.readLine();
        String[] chArr = new String[str.length()];

        for (int i = 0; i < str.length(); i++){
            chArr[i] = str.substring(i);
        }
        Arrays.sort(chArr);

        for(int i = 0; i < chArr.length; i++){
            bw.write(chArr[i]);
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }
}
