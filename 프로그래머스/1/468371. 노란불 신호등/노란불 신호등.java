import java.io.*;
import java.util.*;

class Solution {
    public int solution(int[][] signals) {
        int[] sum = new int[signals.length];
        int[][] arr = new int[signals.length][21];
        int answer = 0;

        for (int i = 0; i < signals.length; i++) {
            for (int j = 0; j < 3; j++) {
                sum[i] += signals[i][j];
            }
        }

        for (int i = 0; i < signals.length; i++) {
            for (int j = signals[i][0] + 1; j <= signals[i][0] + signals[i][1]; j++) {
                arr[i][j] = 1;
            }
        }

        for (int i = 1; i <= 100000000; i++) {
            int count = 0;

            for (int j = 0; j < signals.length; j++) {
                if (arr[j][i % sum[j]] == 1) {
                    count++;
                }
            }

            if (count == sum.length) {
                return i;
            }
        }

        return -1;
    }
}