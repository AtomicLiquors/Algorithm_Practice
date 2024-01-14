// 암기왕
import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		
        for(int tc = 0; tc < T; tc++){
            StringBuilder sb = new StringBuilder();
	        int N = Integer.parseInt(br.readLine());
	        int[] arr = new int[N];
	        StringTokenizer st = new StringTokenizer(br.readLine());
	        for(int i = 0; i < N; i++){
        		arr[i] = Integer.parseInt(st.nextToken());
    	    }
	        Arrays.sort(arr);

	        int M = Integer.parseInt(br.readLine());
    	    st = new StringTokenizer(br.readLine());
	        for(int j = 0; j < M; j++){
		        int curr = Integer.parseInt(st.nextToken());
		        sb.append(Arrays.binarySearch(arr, curr) > -1 ? 1 : 0).append("\n");
    	    }
            sb.deleteCharAt(sb.length() - 1);
	        System.out.println(sb);
        }
        br.close();
	}
}
