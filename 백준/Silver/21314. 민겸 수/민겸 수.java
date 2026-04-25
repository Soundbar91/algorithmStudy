import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();

        System.out.println(findMaxValue(str));
        System.out.print(findMinValue(str));
    }

    public static String findMaxValue(String str) {
       StringBuilder sb = new StringBuilder();

       for (int i = 0; i < str.length();) {
           char c = str.charAt(i);

           if (c == 'M') {
               int index = i;

               while (index < str.length() && str.charAt(index) != 'K') {
                   index++;
               }

               if (index < str.length() && str.charAt(index) == 'K') {
                   sb.append(5);
                   sb.append("0".repeat(index - i));
               }
               else {
                   if (index == str.length()) {
                       sb.append("1".repeat(index - i));
                   }
                   else {
                       sb.append(1);
                       sb.append("0".repeat(index - i - 1));
                   }
               }
               i = index + 1;
           }
           else {
               sb.append(5);
               i++;
           }
       }

       return sb.toString();
    }

    public static String findMinValue(String str) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < str.length();) {
            char c = str.charAt(i);

            if (c == 'M') {
                int index = i;

                while (index < str.length() && str.charAt(index) != 'K') {
                    index++;
                }

                sb.append(1);
                sb.append("0".repeat(index - i - 1));
                if (index < str.length() && str.charAt(index) == 'K') sb.append(5);

                i = index + 1;
            }
            else {
                sb.append(5);
                i++;
            }
        }

        return sb.toString();
    }
}
