import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int R, C;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static Point[][] points;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        points = new Point[R][C];
        for (int i = 0; i < R; i++) {
            String str = br.readLine();
            for (int j = 0; j < C; j++) {
                points[i][j] = new Point(str.charAt(j), 0, 0, false, false);
            }
        }

        int[] playerCoordinate = getPlayerCoordinate();

        moveWater(getWaterCoordinates());
        System.out.print(movePlayer(playerCoordinate[0], playerCoordinate[1]));
        br.close();
    }

    public static int[] getPlayerCoordinate() {
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (points[i][j].mark == 'S') {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{-1, -1};
    }

    public static List<int[]> getWaterCoordinates() {
        List<int[]> coordinates = new LinkedList<>();
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (points[i][j].mark == '*') {
                    coordinates.add(new int[]{i, j});
                }
            }
        }
        return coordinates;
    }

    public static boolean isValid(int x, int y) {
        return x < 0 || x >= R || y < 0 || y >= C;
    }

    public static void moveWater(List<int[]> coordinates) {
        Queue<int[]> queue = new LinkedList<>();
        coordinates.forEach(coordinate -> {
            queue.offer(coordinate);
            points[coordinate[0]][coordinate[1]].waterVisited = true;
        });

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = poll[0] + dx[i];
                int ny = poll[1] + dy[i];

                if (isValid(nx, ny) || points[nx][ny].mark == 'X' || points[nx][ny].mark == '*' || points[nx][ny].mark == 'D' || points[nx][ny].waterVisited) {
                    continue;
                }

                points[nx][ny].waterTime = points[poll[0]][poll[1]].waterTime + 1;
                points[nx][ny].waterVisited = true;
                queue.add(new int[]{nx, ny});
            }
        }
    }

    public static String movePlayer(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});
        points[x][y].playerVisited = true;

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();

            if (points[poll[0]][poll[1]].mark == 'D') {
                return String.valueOf(points[poll[0]][poll[1]].playerTime);
            }

            for (int i = 0; i < 4; i++) {
                int nx = poll[0] + dx[i];
                int ny = poll[1] + dy[i];

                if (isValid(nx, ny) || points[nx][ny].mark == 'X' || points[nx][ny].mark == '*' || points[nx][ny].playerVisited) {
                    continue;
                }

                if (points[nx][ny].waterVisited && points[poll[0]][poll[1]].playerTime + 1 >= points[nx][ny].waterTime) {
                    continue;
                }

                points[nx][ny].playerTime = points[poll[0]][poll[1]].playerTime + 1;
                points[nx][ny].playerVisited = true;
                queue.add(new int[]{nx, ny});
            }
        }

        return "KAKTUS";
    }

    public static class Point {
        char mark;
        int waterTime;
        int playerTime;
        boolean waterVisited;
        boolean playerVisited;

        public Point(char mark, int waterTime, int playerTime, boolean waterVisited, boolean playerVisited) {
            this.mark = mark;
            this.waterTime = waterTime;
            this.playerTime = playerTime;
            this.waterVisited = waterVisited;
            this.playerVisited = playerVisited;
        }
    }
}
