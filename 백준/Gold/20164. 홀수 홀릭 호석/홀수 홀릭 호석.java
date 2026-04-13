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

    static int max = -1, min = 987654321;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        solve(Integer.parseInt(br.readLine()), 0);
        System.out.print(min + " " + max);
        br.close();
    }

    public static void solve(int num, int count) {
        count += calc(num);

        if (num < 10) {
            max = Math.max(max, count);
            min = Math.min(min, count);
        } else if (num < 100) {
           int n1 = num / 10;
           int n2 = num % 10;
           solve(n1 + n2, count);
        } else {
            String value = String.valueOf(num);
            for (int i = 0; i < value.length() - 2; i++) {
                for (int j = i + 1; j < value.length() - 1; j++) {
                    int n1 = Integer.parseInt(value.substring(0, i + 1));
                    int n2 = Integer.parseInt(value.substring(i + 1, j + 1));
                    int n3 = Integer.parseInt(value.substring(j + 1));

                    solve(n1 + n2 + n3, count);
                }
            }
        }
    }

    public static int calc(int num) {
        int count = 0;
        int temp = num;

        while (temp > 0) {
            count += (temp % 10 % 2 != 0 ? 1 : 0);
            temp /= 10;
        }

        return count;
    }
}
