import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
 
public class Main {
	public static int N, K;
	public static int[] map;
	public static int result = 0;
	public static boolean[] visited;
	
    public static void main(String[] args) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	N = Integer.parseInt(st.nextToken());
    	K = Integer.parseInt(st.nextToken());
    	
    	map = new int[K];
    	visited = new boolean[K];
    	
    	st = new StringTokenizer(br.readLine());
    	for(int i=0;i<K;i++) {
    		map[i] = Integer.parseInt(st.nextToken());
    	}
    	
    	
    	simulate(new StringBuilder(), 0);
    	System.out.println(result);
    }
    
    public static void simulate(StringBuilder sb, int level) {
    	
    	if(level > 0) {
        	int a = Integer.parseInt(sb.toString());
        	if(a > N) return;
    		if( a <= N) {
    			result = Math.max(result,  a);
    		}    		
    	}
 
    	for(int i=0;i<K;i++) {
			sb.append(map[i]);
			simulate(sb, level + 1);
			sb.deleteCharAt(sb.length()-1);
    	}
    	
    }
    
}