import java.io.*;
import java.util.*;

public class Main {

    static int N, M;
    static Map<String, List<String>> teams = new HashMap<>();
    static Map<String, String> member = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            String teamName = br.readLine();
            int count = Integer.parseInt(br.readLine());
            List<String> teamMember = new ArrayList<>();

            for (int j = 0; j < count; j++) {
                String memberName = br.readLine();
                teamMember.add(memberName);
                member.put(memberName, teamName);
            }

            teamMember.sort(null);
            teams.put(teamName, teamMember);
        }

        for (int i = 0; i < M; i++) {
            String input = br.readLine();
            int type = Integer.parseInt(br.readLine());

            if (type == 1) {
                sb.append(member.get(input)).append('\n');
            } else if (type == 0) {
                List<String> memberNames = teams.get(input);
                for (String memberName : memberNames) {
                    sb.append(memberName).append('\n');
                }
            }
        }

        System.out.print(sb);
        br.close();
    }
}
