import java.io.*;
import java.util.*;

/**
 * 1347. 미로 만들기
 * 미로 안의 한 칸에서 남쪽을 보며 서있다.
 * 자신의 움직임을 모두 노트에 쓰기로 했다.
 * F : 앞으로 한 칸, L/R : 왼쪽 또는 오른쪽으로 전환
 *
 *
 * 시작 위치를 어떻게 알 수 있을까 ?
 * 입력으로 주어진 대로 움직인다 ?
 * 최대 49번 움직임
 * (0,0)에서 시작한 것을 가정하고 다 움직이고, 값을 보정해서 그래프를 나타낸다 ?
 */

public class Main {

    static int L, dir = 0;
    static char[] notes;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        L = Integer.parseInt(br.readLine());
        notes = br.readLine().toCharArray();

        solve();
        br.close();
    }

    public static void solve() {
        StringBuilder sb = new StringBuilder();

        List<int[]> list = search();

        int maxX = -987654321, maxY = -987654321;
        int minX = 987654321, minY = 987654321;
        for (int i = 0; i < list.size(); i++) {
            int[] cur = list.get(i);
            maxX = Math.max(maxX, cur[0]);
            maxY = Math.max(maxY, cur[1]);
            minX = Math.min(minX, cur[0]);
            minY = Math.min(minY, cur[1]);
        }

        int newX = maxX - minX, newY = maxY - minY;
        List<int[]> changes = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            int[] cur = list.get(i);
            int nx = cur[0] - minX;
            int ny = cur[1] - minY;
            changes.add(new int[]{nx, ny});
        }

        char[][] map = new char[newX + 1][newY + 1];
        for (int i = 0; i <= newX; i++) {
            Arrays.fill(map[i], '#');
        }

        for (int i = 0; i < changes.size(); i++) {
            int[] cur = changes.get(i);
            map[cur[0]][cur[1]] = '.';
        }

        for (int i = 0; i <= newX; i++) {
            for (int j = 0; j <= newY; j++) {
                sb.append(map[i][j]);
            }
            sb.append('\n');
        }

        System.out.print(sb);
    }

    public static List<int[]> search() {
        List<int[]> list = new ArrayList<>();
        int[] start = new int[]{0, 0};
        list.add(start);

        for (int i = 0; i < L; i++) {
            int[] cur = list.get(list.size() - 1);

            if (notes[i] == 'R') {
                dir = (dir + 1) % 4;
            } else if (notes[i] == 'L') {
                dir = (dir - 1 + 4) % 4;
            } else {
                int nx = cur[0] + dx[dir];
                int ny = cur[1] + dy[dir];
                list.add(new int[]{nx, ny});
            }
        }

        return list;
    }
}
