import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int L;
    static int C;
    static boolean[] visit;
    static int[] node;
    static int[] charNum;

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        charNum = new int[C];
        visit = new boolean[C];
        node = new int[L];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < C; i++){
            charNum[i] = st.nextToken().charAt(0);
        }

        Arrays.sort(charNum);
        dfs(0, 0, 0, 0);

        System.out.print(sb);
    }

    // consonant - 자음 / vowel - 모음
    public static void dfs(int index, int depth, int consonantCnt, int vowelCnt){
        if (depth == L){
            if (consonantCnt >= 2 && vowelCnt >= 1) {
                for (int i : node){
                    sb.append((char)(i));
                }
                sb.append('\n');
            }
        }

        else {
            for (int i = index; i < C; i++){
                if (!visit[i]){
                    visit[i] = true;
                    node[depth] = charNum[i];
                    if (valid(charNum[i])) dfs(i + 1,depth + 1, consonantCnt, vowelCnt + 1);
                    else dfs(i + 1, depth + 1, consonantCnt  + 1, vowelCnt);
                    visit[i] = false;
                }
            }
        }
    }

    public static boolean valid(int n){
        return n == 97 || n == 101 || n == 105 || n == 111 || n == 117;
    }
}
