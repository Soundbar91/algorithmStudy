import java.io.*;
import java.util.*;

/**
 * 20164. 홀수 홀릭 호선
 * 수의 각 자리 숫자 중에서 홀수의 개수를 종이에 적는다
 * 수가 한 자리이면 더 이상 아무것도 하지 못하고 종료한다
 * 수가 두 자리이면 2개로 나눠서 합을 구하여 새로운 수로 생각한다
 * 수가 세 자리 이상이면 임의의 위치에서 끊어서 3개의 수로 분할하고, 3개를 더한 값을 새로운 수로 생각한다
 * 모든 수를 더한다.
 *
 * 세 자리 이상일 때, 숫자를 어떻게 짜르냐에 따라 결과값이 달라짐
 * 일단 완탐 구현
 */

public class Main {

    static int N, min = 987654321, max = -1, count = 0, cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();
        N = Integer.parseInt(input);

        cnt = calc(N);
        count = cnt;

        if (input.length() == 1) {
            if (N % 2 != 0) {
                System.out.print("0 1");
            } else {
                System.out.print("0 0");
            }
        } else if (input.length() == 2) {
            calcIfNumLenEqualsTwo(N);
            System.out.print(count + " " + count);
        } else {
            solve(N, 0);
            System.out.print(min + " " + max);
        }

        br.close();
    }

    public static void solve(int num, int depth) {
        if (num < 10) {
            return ;
        } else if (num < 100) {
            solve(calcIfNumLenEqualsTwo(num), depth + 1);
        } else {
            String n = String.valueOf(num);

            for (int i = 1; i < n.length() - 1; i++) {
                for (int j = i + 1; j < n.length(); j++) {
                    solve(calcIfNumLenOverTwo(num, i, j), depth + 1);

                    if (depth == 0) {
                        min = Math.min(min, count);
                        max = Math.max(max, count);
                        count = cnt;
                    }
                }
            }
        }
    }

    public static int calcIfNumLenEqualsTwo(int num) {
        int n1 = num % 10;
        int n2 = num / 10;
        int n3 = n1 + n2;
        count += calc(n3);

        return n3;
    }

    public static int calcIfNumLenOverTwo(int num, int idx1, int idx2) {
        int n1 = (int)(num % (Math.pow(10, idx1)));
        int n2 = (int)((int)(num / (Math.pow(10, idx1))) % (Math.pow(10, idx2 - idx1)));
        int n3 = (int)((int)(num / (Math.pow(10, idx1))) / (Math.pow(10, idx2 - idx1)));
        int n4 = n1 + n2 + n3;
        count += calc(n4);

        return n4;
    }

    public static int calc(int num) {
        String n = String.valueOf(num);
        int calc = 0;

        for (int i = 0; i < n.length(); i++) {
            if (n.charAt(i) % 2 != 0) {
                calc++;
            }
        }

        return calc;
    }
}
