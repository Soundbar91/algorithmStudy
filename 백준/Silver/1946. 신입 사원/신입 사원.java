import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Main {
    static int T, N;
    static List<Volunteer> volunteers;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            N = Integer.parseInt(br.readLine());
            volunteers = new ArrayList<>();

            while (N-- > 0) {
                st = new StringTokenizer(br.readLine());

                int documentScreening = Integer.parseInt(st.nextToken());
                int interviewScreening = Integer.parseInt(st.nextToken());

                volunteers.add(new Volunteer(documentScreening, interviewScreening));
            }

            System.out.println(solve());
        }

        br.close();
    }

    public static int solve() {
        volunteers.sort(null);
        int count = 1;
        int stand = volunteers.get(0).interviewScreening;

        for (int i = 1; i < volunteers.size(); i++) {
            Volunteer volunteer = volunteers.get(i);
            if (volunteer.interviewScreening < stand) {
                count++;
                stand = volunteer.interviewScreening;
            }
        }

        return count;
    }

    public static class Volunteer implements Comparable<Volunteer> {
        int documentScreening;
        int interviewScreening;

        public Volunteer(int documentScreening, int interviewScreening) {
            this.documentScreening = documentScreening;
            this.interviewScreening = interviewScreening;
        }

        @Override
        public int compareTo(Volunteer o) {
            return documentScreening - o.documentScreening;
        }
    }
}
