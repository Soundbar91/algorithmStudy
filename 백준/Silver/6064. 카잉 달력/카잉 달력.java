import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        while(T-- > 0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            int value = LCM(M, N);

            int wightX = 0;
            int wightY = 0;

            while (true){
                int valueX = M * wightX + x;
                int valueY = N * wightY + y;

                if (valueX > value || valueY > value){
                    sb.append(-1).append('\n');
                    break;
                }

                if (valueX == valueY){
                    sb.append(valueX).append('\n');
                    break;
                }
                else {
                    if (valueX < valueY){
                        wightX++;
                    }
                    else{
                        wightY++;
                    }
                }
            }
        }
        System.out.print(sb);
    }

    public static int LCM(int x, int y){
        if (x < y){
            int temp = x;
            x = y;
            y = temp;
        }

        return x * y / GCD(x, y);
    }

    public static int GCD(int x, int y){

        while(x % y != 0){
            int temp = x % y;
            x = y;
            y = temp;
        }

        return y;
    }
}
