package binarysearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_2805 {
    public static void main(String[] args) throws IOException {
        /* 나무 자르기 문제 */
        /*
        * 누적합과 두 가지의 이분탐색을 혼합해서 푸는 문제.
        * 1. mid : 이분탐색을 통해 설정한 임의의 높이.
        * 2. key : trees에서 "현재 mid값보다 작거나 같은 나무"가 존재하는 구간의 끝 인덱스.
        * 3. 누적합 - 누적합으로 특정 구간의 나무 높이 총합을 구하고, 구간 길이 * mid를 빼서, 자르고 남은 나무 길이 합을 구한다.
        * 4. 그 결과가 주어진 값보다 크거나 같으면 정답을 갱신하고, 최대 높이를 찾아 높이를 top쪽으로 이동한다.
        * 5. 그 결과가 주어진 값보다 작다면, 나무를 더 넉넉하게 자르기 위해 높이를 bottom 쪽으로 이동한다.
        */

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        // DEBUG 1 : int 최댓값에 근접한 배열의 누적합은 int overflow를 일으킨다. long을 사용한다.
        long[] trees = new long[N+1];
        long[] prefix = new long[N+1];

        for (int i = 1; i <= N; i++) {
            trees[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(trees);
        for (int i = 1; i <= N; i++) {
            prefix[i] = prefix[i-1] + trees[i];
        }

        long bottom = 0;
        long top = trees[N];
        long answer = -1;
        long mid;

        while(bottom <= top){
            mid = (bottom + top) / 2;
            int key = Arrays.binarySearch(trees, mid);

            // DEBUG 2 : key = key > 0 ? key : -key -2로 했을 때는 key = 0일 때 key를 -2로 바꿔 버린다.
            if(key < 0)
                key = -key - 2;


            long result = (prefix[N] - prefix[key]) - mid * (N - key);

            if(result >= M){
                // DEBUG 3 : mid + 1이 아니라 mid를 대입하면 무한 루프가 일어난다.
                bottom = mid + 1;
                answer = mid;
            }else{
                top = mid - 1;
            }
        }

        // DEBUG 4 : 정답 변수를 따로 만들지 않고 mid를 바로 출력했을 땐 오답이 났다.
        // mid는 정답을 발견하고 난 뒤 다음 반복 회차에서 정답보다 큰 값으로 변해버리기 때문이다.
        System.out.println(answer);
    }
}
