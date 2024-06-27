import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Main {
    static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
    static int N;
    static int L;
    static int F;
    static Map<String, Map<String, String>> map = new HashMap<>();
    static Map<String, Long> result = new HashMap<>();

    public static void main(String[] args) throws IOException, ParseException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        String[] dayInfo = st.nextToken().split("[/:]");
        L = Integer.parseInt(dayInfo[0]) * 24 * 60 + Integer.parseInt(dayInfo[1]) * 60 + Integer.parseInt(dayInfo[2]);
        F = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            String[] split = br.readLine().split(" ");
            Map<String, String> temp = map.getOrDefault(split[2], new HashMap<>());
            String date = split[0] + " " + split[1];

            if (!temp.containsKey(split[3])) temp.put(split[3], date);
            else {
                String s = temp.get(split[3]);
                LocalDateTime first = LocalDateTime.parse(s, formatter);
                LocalDateTime second = LocalDateTime.parse(date, formatter);

                Duration duration = Duration.between(first, second);
                long time = duration.getSeconds() / 60 - L;
                if (time > 0) result.put(split[3], result.getOrDefault(split[3], 0L) + (time * F));

                temp.remove(split[3]);
            }
            map.put(split[2], temp);
        }

        if (result.isEmpty()) System.out.print("-1");
        else result();
        br.close();
    }

    public static void result() {
        List<String> keySet = new ArrayList<>(result.keySet());
        Collections.sort(keySet);

        for (String str : keySet) {
            long i = result.get(str);
            System.out.println(str + " " + i);
        }
    }
}
