import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String str = "WelcomeToSMUPC";
        
        System.out.println(str.charAt((n - 1) % 14));
    }
}
