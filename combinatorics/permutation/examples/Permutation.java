package combinatorics.permutation.examples;

import java.util.Arrays;

public class Permutation {
	
	private static int[] numbers;
	private static boolean[] isSelected;
	private static int N, R;

	
	public static void main(String[] args) {
		
		N = 5;
		R = 3;
		numbers = new int[R];
		isSelected = new boolean[N+1]; 
		//중복체크 배열, 왜 N+1인가!  
		//0부터 시작하는 인덱스를 실제 숫자와 맞추기 위해. 일일이 i-1하지 말고.
		//flag는 가독성이 떨어짐, isSelected - true, false라고 하면 직관적으로 의미가 와닿지.
		//참고로 boolean 배열은 초깃값이 false
		permutation(0);
		
		
	}
	
	private static void permutation(int cnt) { //해당자리에 들어갈 수 뽑기
		
		if(cnt == R) {
			System.out.println(Arrays.toString(numbers));
			return;
		}
		for (int i = 1; i <= N; i++) {// 중복체크
			if(isSelected[i]) continue;
			numbers[cnt] = i; 
			isSelected[i] = true;
			permutation(cnt+1); // 수를 뽑고 다음 수로.
			isSelected[i] = false; //배열이 하나 완성됐으면, 다음 배열 뽑을 거니까 플래그 초기화.
		}
	}
}



/*
1. 전체문제를 작은 부분 문제로 해결 가능한지 따져본다.
  
//1, 2, 3에 대한 모든 순열
//첫 번째 수와, 그 나머지

2. **메서드의 역할을 정확히 인지한다.**
‘현재 할것’과 그 ‘나머지’. 
'현재 할 것'은 '나머지'와 동일한 형태여야 함.


  
3. 함수의 결정요인을 매개변수로 정의할것.
// 현재 배열의 길이 -> cnt ( 0 <= cnt <= R )
// 수가 들어가 있는가 -> 불리언 캐시 isSelected

4. **기저조건을 확인한다.**
//R 길이만큼 배열이 완성되었을 때 -> 만들어진 배열을 출력하고, 리턴. 
//하위 재귀가 한번 끝났으면 새 배열을 만들 차례다. isSelected[i] = false; 
 
5. 자기가 처리할 내용과 다음 재귀로 넘길 내용을 구분한다.
”Flat”하게 보는 것 : 큰 문제를 다 해결할 게 아니라, 내가 할 수 있는 일을 한다.
*/
