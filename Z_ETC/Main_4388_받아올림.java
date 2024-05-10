package Z_ETC;

import java.util.Scanner;

public class Main_4388_받아올림 {
	public static void main(String[] args) {
		Scanner sc =new Scanner(System.in);
		while(true) {
			long a = sc.nextLong();
			long b = sc.nextLong();
			if(a == 0 && b == 0) break;
			
			long sum = a + b;
			int div = 10;
			int cnt = 0;
			while(sum/div!=0) {
				if(sum % div != a % div + b % div) cnt++;
				div *= 10;
			}
			System.out.println(cnt);
		}
		
		
	}
}

