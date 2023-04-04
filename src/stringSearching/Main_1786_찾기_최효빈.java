import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1786_찾기_최효빈 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String T = br.readLine();
		String P = br.readLine();
		
		int tLength = T.length();
		int pLength = P.length();
		//부분일치 테이블
		int[] pi = new int[pLength];
		
		pi[0] = 0;
		
		int i = 1;
		int j = 0;
		
		while(i < pLength) {
			while(true) {
				if(P.charAt(i)==P.charAt(j)) {
					pi[i] = j + 1;
					j++;
					break;
				}else if(j > 0){
					j = pi[j-1];
				}else {
					break;
				}
			}
			i++;
		}
		
		i = 0;
		j = 0;
		int cnt = 0;
		StringBuilder sb = new StringBuilder();
		while(i < tLength) {
			while(j < pLength) {
				if(T.charAt(i)==P.charAt(j)) {
					j++;
					if(j==pLength) {
						cnt++;
						sb.append(i-pLength+2).append(" ");
						//i = i-pLength+1;
						j = pi[j-1];
						//pi를 활용하지 않고, i를 거꾸로 돌리려고 해서 TLE 났다
					}
					break;
				}else {
					if(j > 0) j = pi[j-1];
					else break;
				}
			}
			i++;
		}
		//System.out.println(Arrays.toString(pi));

		System.out.println(cnt);
		System.out.println(sb);		
	}
}
