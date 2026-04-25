import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        char[] S = br.readLine().toCharArray();

        System.out.print(solved(N, M, S));
        br.close();
    }

    public static int solved(int N, int M, char[] S) {
        int result = 0;
        int cnt = 0;

        for (int i = 1; i < M - 1;) {
            if (S[i] == 'O' && S[i + 1] == 'I') {
                cnt++;

                if (cnt == N) {
                    if (S[i - (cnt * 2 - 1)] == 'I') result++;
                    cnt--;
                }

                i += 2;
            }
            else {
                cnt = 0;
                i++;
            }
        }

        return result;
    }
}
