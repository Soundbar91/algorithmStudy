import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = "";

        while ((str = br.readLine()) != null) {
            int n = Integer.parseInt(str);
            System.out.println(solve(n));
        }

        br.close();
    }

    public static int solve(int n) {
        BigInteger value = new BigInteger(String.valueOf(n));
        BigInteger base = BigInteger.ZERO;

        while (true) {
            base = base.multiply(BigInteger.TEN).add(BigInteger.ONE);
            if (base.mod(value).equals(BigInteger.ZERO)) {
                return base.toString().length();
            }
        }
    }
}
