import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {
    static int N, M, H, W, Sr, Sc, Fr, Fc;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};
    static int[][] map;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        visited = new boolean[N + 1][M + 1];

        map = new int[N + 1][M + 1];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        Sr = Integer.parseInt(st.nextToken());
        Sc = Integer.parseInt(st.nextToken());
        Fr = Integer.parseInt(st.nextToken());
        Fc = Integer.parseInt(st.nextToken());

        System.out.print(solve());
        br.close();
    }

    public static int solve() {
        Queue<Rectangle> queue = new LinkedList<>();
        queue.add(new Rectangle(Sr, Sc, Sr + H - 1, Sc + W - 1, 0));

        while (!queue.isEmpty()) {
            Rectangle cur = queue.poll();

            if (cur.Sr == Fr && cur.Sc == Fc) return cur.count;

            if (visited[cur.Sr][cur.Sc]) continue;
            visited[cur.Sr][cur.Sc] = true;

            for (int i = 0; i < 4; i++) {
                int Sx = cur.Sr + dx[i];
                int Sy = cur.Sc + dy[i];
                int Ex = cur.Er + dx[i];
                int Ey = cur.Ec + dy[i];

                if (!valid(Sx, Sy) || visited[Sx][Sy] || map[Sx][Sy] == 1) continue;
                if (!valid(Ex, Ey) || map[Ex][Ey] == 1) continue;

                if (check(Sx, Sy, Ex, Ey))
                    queue.add(new Rectangle(Sx, Sy, Ex, Ey, cur.count + 1));
            }
        }

        return -1;
    }

    public static boolean valid(int x, int y) {
        return x > 0 && x <= N && y > 0 && y <= M;
    }

    public static boolean check(int Sx, int Sy, int Ex, int Ey) {
        for (int i = Sx; i <= Ex; i++) if (map[i][Sy] == 1) return false;
        for (int i = Sy; i <= Ey; i++) if (map[Sx][i] == 1) return false;
        for (int i = Ex; i >= Sx; i--) if (map[i][Ey] == 1) return false;
        for (int i = Ey; i >= Sy; i--) if (map[Ex][i] == 1) return false;
        return true;
    }

    public static class Rectangle {
        int Sr, Sc, Er, Ec, count;

        public Rectangle(int sr, int sc, int er, int ec, int count) {
            Sr = sr;
            Sc = sc;
            Er = er;
            Ec = ec;
            this.count = count;
        }
    }
}
