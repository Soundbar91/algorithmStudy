import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int[] cnt = new int[26];
        String str = br.readLine();

        for (char ch : str.toCharArray()){
            cnt[ch - 'a'] += 1;
        }

        for (int i = 0; i < 25; i++){
            sb.append(cnt[i]).append(' ');
        }
        sb.append(cnt[25]);
        System.out.println(sb);

    }
}
