import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_R885_A_IsItaCat {
	

	static int N;
	static int[] meow = {77, 69, 79, 87};
	
	
    public static void main(String[] args) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int T = Integer.parseInt(br.readLine());
    	
    	for (int i = 0; i < T; i++) {
    		N = Integer.parseInt(br.readLine());
    		
    		String line = br.readLine();
    		
    		System.out.println(isMeow(line)?"YES":"NO");
    		
		}
    	
    }
    
    static boolean isMeow(String line) throws IOException{
    	int idx = 0;
    	boolean[] visited = new boolean[4];
    	
    	for (int j = 0; j < N; j++) {
			int c = line.charAt(j);
			c = (c > 90? c-32: c);
			
			
			if(c != meow[idx] ) {
				if(idx==3) 
					return false;
				else if(c != meow[++idx]) {
					return false;
				}else {
					visited[idx] = true;
				}
			}else {
				visited[idx] = true;
			}
		}
    	for (int i = 0; i < 4; i++) {
			if(visited[i] == false) return false;
		}
    	return true;
    }
}