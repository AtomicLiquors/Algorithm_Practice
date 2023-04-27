import java.util.Arrays;
import java.util.Scanner;

public class Main_크리문자열 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		
		int len = str.length();
		int[] arr = new int[len+1];
		
		for (int i = 0; i < len; i++) {
			arr[i+1] = arr[i] + str.charAt(i)-'0';
		}
		
		
		for (int part = (len%2==0?len:len-1); part > 0; part-=2) {
			for (int ptR = part; ptR <= len; ptR++) {
				
				int ptL = ptR-(part/2);
				int pt0 = ptL-(part/2);
				
				if(arr[ptR]-arr[ptL] == arr[ptL]-arr[pt0]) {
					System.out.println(part);
					return;
				}
			}
		}
		
		
	}

}
