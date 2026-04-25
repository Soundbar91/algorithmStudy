import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int k;
    static boolean[] visit;
    static char[] A;
    static int[] node;
    static ArrayList<String> result = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        k = Integer.parseInt(br.readLine());
        visit = new boolean[10];
        node = new int[k + 1];
        A = new char[k];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < k; i++){
            A[i] = st.nextToken().charAt(0);
        }

        for (int i = 0; i < 10; i++){
            visit[i] = true;
            dfs(i, 0, i + "");
            visit[i] = false;
        }

        System.out.println(result.get(result.size() - 1));
        System.out.print(result.get(0));
    }

    public static void dfs(int index, int depth, String value){
        if (value.length() == k + 1){
            result.add(value);
        }

        else {
            for (int i = 0; i < 10; i++){
                if (!visit[i]){
                    if (A[depth] == '<'){
                        if (index < i){
                            visit[i] = true;
                            dfs(i, depth + 1, value + i);
                            visit[i] = false;
                        }
                    }
                    else {
                        if (index > i){
                            visit[i] = true;
                            dfs(i, depth + 1, value + i);
                            visit[i] = false;
                        }
                    }
                }
            }
        }
    }
}