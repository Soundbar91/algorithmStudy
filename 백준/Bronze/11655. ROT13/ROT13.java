import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String str = br.readLine();
        for (char ch : str.toCharArray()){
            if (65 <= ch && 90 >= ch){
                sb.append((char)(65 + (((int)(ch - 'A') + 13)) % 26));
            }
            else if (97 <= ch && 122 >= ch){
                sb.append((char)(97 + (((int)(ch - 'a') + 13)) % 26));
            }
            else{
                sb.append(ch);
            }
        }
        System.out.println(sb);
    }
}
