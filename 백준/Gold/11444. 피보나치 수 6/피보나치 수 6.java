import java.io.*;

public class Main {
    static final long MOD = 1_000_000_007;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine());
        
        System.out.println(fibonacci(n));
    }
    
    static long fibonacci(long n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        
        long[][] result = matrixPower(new long[][]{{1, 1}, {1, 0}}, n);
        return result[0][1];
    }
    
    static long[][] matrixPower(long[][] matrix, long exp) {
        long[][] result = {{1, 0}, {0, 1}};
        
        while (exp > 0) {
            if (exp % 2 == 1) {
                result = matrixMultiply(result, matrix);
            }
            matrix = matrixMultiply(matrix, matrix);
            exp /= 2;
        }
        
        return result;
    }
    
    static long[][] matrixMultiply(long[][] a, long[][] b) {
        long[][] result = new long[2][2];
        
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                for (int k = 0; k < 2; k++) {
                    result[i][j] = (result[i][j] + a[i][k] * b[k][j]) % MOD;
                }
            }
        }
        
        return result;
    }
}