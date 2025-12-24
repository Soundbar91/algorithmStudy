import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int result = 987654321;
    static int[] dz = {0, 0, 0, 0, 1, -1};
    static int[] dx = {-1, 1, 0, 0, 0, 0};
    static int[] dy = {0, 0, -1, 1, 0, 0};
    static int[] mode = new int[5];
    static int[][][] map = new int[5][5][5];
    static int[] order = new int[5];
    static boolean[] used = new boolean[5];
    static int[][][] copyMap;
    static boolean[][][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < 5; k++) {
                    map[i][j][k] = Integer.parseInt(st.nextToken());
                }
            }
        }

        permutation(0);
        System.out.print(result == 987654321 ? -1 : result);
        br.close();
    }

    public static void permutation(int depth) {
        if (depth == 5) {
            solve(0);
        } else {
            for (int i = 0; i < 5; i++) {
                if (!used[i]) {
                    used[i] = true;
                    order[depth] = i;
                    permutation(depth + 1);
                    used[i] = false;
                }
            }
        }
    }

    public static void solve(int depth) {
        if (depth == 5) {
            copyMap = new int[5][5][5];

            for (int i = 0; i < 5; i++) {
                turn(mode[i], order[i], i);
            }

            bfs();
        } else {
            for (int i = 0; i < 4; i++) {
                mode[depth] = i;
                solve(depth + 1);
            }
        }
    }

    public static void turn(int mode, int srcIndex, int destIndex) {
        for (int j = 0; j < 5; j++) {
            for (int k = 0; k < 5; k++) {
                if (mode == 0) {
                    copyMap[destIndex][j][k] = map[srcIndex][j][k];
                } else if (mode == 1) {
                    copyMap[destIndex][k][4 - j] = map[srcIndex][j][k];
                } else if (mode == 2) {
                    copyMap[destIndex][4 - j][4 - k] = map[srcIndex][j][k];
                } else if (mode == 3) {
                    copyMap[destIndex][4 - k][j] = map[srcIndex][j][k];
                }
            }
        }
    }

    public static void bfs() {
        if (copyMap[0][0][0] == 0 || copyMap[4][4][4] == 0) {
            return ;
        }

        Queue<Node> queue = new LinkedList<>();
        visited = new boolean[5][5][5];
        queue.add(new Node(0, 0, 0, 0));
        visited[0][0][0] = true;

        while (!queue.isEmpty()) {
            Node cur = queue.poll();

            if (exit(cur.x, cur.y, cur.z)) {
                result = Math.min(result, cur.count);
                break;
            }

            for (int i = 0; i < 6; i++) {
                int nz = cur.z + dz[i];
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if (!valid(nx, ny, nz) || visited[nz][nx][ny] || copyMap[nz][nx][ny] == 0) {
                    continue;
                }

                visited[nz][nx][ny] = true;
                queue.add(new Node(nx, ny, nz, cur.count + 1));
            }
        }
    }

    public static boolean valid(int x, int y, int z) {
        return x >= 0 && x < 5 && y >= 0 && y < 5 && z >= 0 && z < 5;
    }

    public static boolean exit(int x, int y, int z) {
        return x == 4 && y == 4 && z == 4;
    }

    public static class Node {
        int x;
        int y;
        int z;
        int count;

        public Node(int x, int y, int z, int count) {
            this.x = x;
            this.y = y;
            this.z = z;
            this.count = count;
        }
    }
}
