import java.io.*;

public class Main {
    static int result = 1;
    static char[][] board;
    static String line;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        board = new char[n][n];

        for (int i = 0; i < n; i++) {
            line = br.readLine();
            for (int j = 0; j < n; j++) {
                board[i][j] = line.charAt(j);
            }
        }
        
        calcCnt();

        for (int i = 0; i < n; i++){
            for (int j = 0; j < n - 1; j++){
                swap(i, j, i, j + 1);
                calcCnt();
                swap(i, j, i, j + 1);
            }
        }

        for (int i = 0; i < n - 1; i++){
            for (int j = 0; j < n; j++){
                swap(i, j, i + 1, j);
                calcCnt();
                swap(i, j, i + 1, j);
            }
        }

        System.out.print(result);
    }

    public static void swap(int x1, int y1, int x2, int y2){
        char temp = board[x1][y1];
        board[x1][y1] = board[x2][y2];
        board[x2][y2] = temp;
    }

    public static void calcCnt(){

        for (int i = 0; i < board.length; i++){
            int cnt = 1;

            for (int j = 0; j < board.length - 1; j++){
                if (board[i][j] == board[i][j + 1]){
                    cnt += 1;
                    result = Math.max(result, cnt);
                }
                else {
                    cnt = 1;
                }
            }
        }

        for (int i = 0; i < board.length; i++){
            int cnt = 1;

            for (int j = 0; j < board.length - 1; j++){
                if (board[j][i] == board[j + 1][i]){
                    cnt += 1;
                    result = Math.max(result, cnt);
                }
                else {
                    cnt = 1;
                }
            }
        }
    }
}
