import java.util.Scanner;

public class CombinationNP {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int R = sc.nextInt();
		
		int[] input = new int[N];
		int[] p = new int[N]; //np에 사용될 각 원소 인덱스의 'flag'역할 배열
		
		for (int i = 0; i < N; i++) {
			input[i] = sc.nextInt();
		}
		//flag역할 배열의 전처리 : R개만큼 뒤에서 1을 채운다. p = {0, 0, 1, 1, 1}
		int cnt = 0;
		while(++cnt<=R) p[N-cnt] = 1;
		
		do {
			for (int i = 0; i < N; i++) {
				if(p[i] != 0) System.out.print(input[i] + " ");
			}
			System.out.println();
		}while(np(p));
	}

	private static boolean np(int[] p) {
		int n = p.length;
		
		int i = n-1;
		while(i>0 && p[i-1]>=p[i]) --i;
		if(i==0) return false;
		
		int j = n-1;
		while(p[i-1] >= p[j]) --j;
		
		swap(p, i-1, j);
		int k = n-1;
		
		while(i<k) {
			swap(p, i++, k--);
		}
		
		return true;
	}
	
	private static void swap(int[] p, int i, int j) {
		int temp = p[i];
		p[i] = p[j];
		p[j] = temp;
	}
}
