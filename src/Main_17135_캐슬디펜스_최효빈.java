import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_17135_캐슬디펜스_최효빈 {



    static Queue<Integer> targets;
    static int[][] map;
    static int[] archers;
    static int N, M, D;
    static int max;

    public static void main(String[] args) throws IOException {


        //static 변수 세팅
        targets = new LinkedList<Integer>();
        archers = new int[3];
        max = 0;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        //0부터 4까지 조합
        aim(N, M, D);
        System.out.println(Arrays.deepToString(map));

        //combArchers(0, 0);
    }
    //거리 1일 때 : a보다
    //거리 2일 때 :
    static void aim(int N, int M, int D) {
        //static 클래스 변수 static 메서드에서 0 되는 이유.

        //어떻게 "같은 거리일 때 왼쪽부터"를 충족할 것인가?
        //단순히 배열을 돌리면 놓칠 수 있으니
        //1) 그때그때 자기 사정거리를 저장하거나
        //2) BFS

        //예상 반례 : D가 칸 수를 넘는 경우.
        for (int a : archers) {

            for (int i = 0; i <= D && i < N; i++) {
                int r = N-1;
                for(int c = a-i; c <= a+i; c++) {
                    if( c >= 0 && c < M && r >= 0) {
                        map[r][c] = 3;
                    }
                    if(c > a) r++;
                    else r--;
                }
            }
        }
    }

    static int attack() {
        return 0;
    }
    static void wave() {

    }

    static void combArchers(int cnt, int start) {
        if(cnt == 3) {

            aim(N, M, D);
            int kills = attack();
            wave();
            //사격 시작
            //최댓값 갱신
            return;
        }

        for (int i = start; i < 5; i++) {
            archers[cnt] = i;
            combArchers(cnt+1, i+1);
        }
    }


}