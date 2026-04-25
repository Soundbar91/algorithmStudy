import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static int S;
    static int[] time;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        S = Integer.parseInt(br.readLine());
        time = new int[1001];
        visited = new boolean[1001][1001];

        bfs();
    }

    public static void bfs(){
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{1, 0, 0});
        visited[0][1] = true;

        while (!queue.isEmpty()){
            int[] node = queue.poll();
            int emoticon = node[0];
            int time = node[1];
            int clipBoard = node[2];

            if (emoticon == S){
                System.out.print(time);
                System.exit(0);
            }

            if (emoticon != clipBoard){
                queue.add(new int[]{emoticon, time + 1, emoticon});
            }
            if (clipBoard != 0 && valid(emoticon + clipBoard) && !visited[clipBoard][emoticon + clipBoard]){
                visited[clipBoard][emoticon + clipBoard] = true;
                queue.add(new int[]{emoticon + clipBoard, time + 1, clipBoard});
            }
            if (valid(emoticon - 1) && !visited[clipBoard][emoticon - 1]){
                visited[clipBoard][emoticon - 1] = true;
                queue.add(new int[]{emoticon - 1, time + 1, clipBoard});
            }
        }
    }

    public static boolean valid(int value){
        return value >= 1 && value <= S;
    }
}
