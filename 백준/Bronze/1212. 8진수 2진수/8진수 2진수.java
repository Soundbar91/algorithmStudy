import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        char[] str = br.readLine().toCharArray();

        if (str.length == 1 && str[0] == '0'){
            System.out.println(0);
            return;
        }

        for (char ch : str){
            switch (ch){
                case '0' :
                    sb.append("000");
                    break;
                case '1' :
                    sb.append("001");
                    break;
                case '2' :
                    sb.append("010");
                    break;
                case '3' :
                    sb.append("011");
                    break;
                case '4' :
                    sb.append("100");
                    break;
                case '5' :
                    sb.append("101");
                    break;
                case '6' :
                    sb.append("110");
                    break;
                case '7' :
                    sb.append("111");
                    break;
            }
        }
        while (sb.charAt(0) == '0') sb.delete(0, 1);
        System.out.print(sb);
    }
}
