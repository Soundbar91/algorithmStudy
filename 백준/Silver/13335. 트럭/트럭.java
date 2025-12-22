import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 1. 다리에 올라갈 수 있는 지 검사
 * 2. 올라갈 수 있으면 큐에 삽입
 * 3. 올라갈 수 없으면 올라갈 수 있는 시간을 구하고, 그 시간동안 나오는 트럭을 뺌 / 이후에 삽입
 */

public class Main {

    static int n, w, L, totalTime = 1, sum;
    static Queue<Truck> trucks = new LinkedList<>();
    static Queue<Truck> bridgeTrucks = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        w = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            trucks.add(new Truck(Integer.parseInt(st.nextToken())));
        }

        solve();
        br.close();
    }

    public static void solve() {
        while(!trucks.isEmpty()) {
            Truck truck = trucks.peek();

            if (!bridgeTrucks.isEmpty() && totalTime - bridgeTrucks.peek().time == w) {
                Truck poll = bridgeTrucks.poll();
                sum -= poll.weight;
            }

            if (valid(truck.weight)) {
                trucks.poll();
                truck.setTime(totalTime);
                bridgeTrucks.add(truck);
                sum += truck.weight;
            }

            totalTime++;
        }

        while (!bridgeTrucks.isEmpty()) {
            Truck truck = bridgeTrucks.peek();

            if (totalTime - truck.time == w) {
                Truck poll = bridgeTrucks.poll();
                sum -= poll.weight;
            }
            totalTime++;
        }

        System.out.print(totalTime - 1);
    }

    public static boolean valid(int weight) {
        return sum + weight <= L;
    }

    public static class Truck {
        int time;
        int weight;

        public Truck(int weight) {
            this.time = 0;
            this.weight = weight;
        }

        public void setTime(int time) {
            this.time = time;
        }
    }
}
