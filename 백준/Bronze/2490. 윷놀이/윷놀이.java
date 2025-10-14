import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for (int i = 0; i < 3; i++) {
            int front = 0;
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < 4; j++) {
                if (Integer.parseInt(st.nextToken()) == 0) front++;
            }
            solve(front);
        }

        br.close();
    }

    public static void solve(int front) {
        if (front == 4) {
            System.out.println("D");
        }
        else if (front == 3) {
            System.out.println("C");
        }
        else if (front == 2) {
            System.out.println("B");
        }
        else if (front == 1) {
            System.out.println("A");
        }
        else {
            System.out.println("E");
        }
    }
}
