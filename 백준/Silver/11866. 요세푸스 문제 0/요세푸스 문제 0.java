import java.io.*;
import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Scanner sc = new Scanner(System.in);
        Queue<Integer> queue = new LinkedList<>();

        int N = sc.nextInt();
        int K = sc.nextInt();
        int size = N;
        int num = K - 1;
        int[] arr = new int[N];

        for (int i = 0; i < N; i++){
            arr[i] = i + 1;
        }

        while (true){
            queue.add(arr[num]);

            for (int i = num; i < size - 1; i++){
                arr[i] = arr[i + 1];
            }
            size -= 1;
            if (size == 0) break;
            num = (num + (K - 1)) % size;
        }

        sb.append('<');
        while (queue.size() != 1){
            sb.append(queue.remove()).append(", ");
        }
        sb.append(queue.remove()).append('>');

        System.out.println(sb);

    }
}
