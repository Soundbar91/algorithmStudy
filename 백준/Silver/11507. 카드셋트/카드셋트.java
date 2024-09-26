import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String cards = br.readLine();

        solve(cards);
        br.close();
    }

    public static void solve(String cards) {
        int[] count = {13, 13, 13, 13};

        Map<Character, List<String>> map = new HashMap<>();
        map.put('P', new ArrayList<>());
        map.put('K', new ArrayList<>());
        map.put('H', new ArrayList<>());
        map.put('T', new ArrayList<>());

        for (int i = 0; i <= cards.length() - 3; i += 3) {
            String card = cards.substring(i, i + 3);

            char c = card.charAt(0);
            String value = card.substring(1);

            List<String> strings = map.get(c);
            if (strings.contains(value)) {
                System.out.print("GRESKA");
                return;
            } else
                strings.add(value);

            switch (c) {
                case 'P':
                    count[0]--;
                    break;
                case 'K':
                    count[1]--;
                    break;
                case 'H':
                    count[2]--;
                    break;
                case 'T':
                    count[3]--;
                    break;
            }
        }

        Arrays.stream(count).forEach(c -> System.out.print(c + " "));
    }
}
