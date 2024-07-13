import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
// https://www.acmicpc.net/status?user_id=gyqls234&problem_id=20303&from_mine=1

public class Main_20303_improved {
    static int[] roots, candies, friends;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        candies = new int[N+1];
        roots = new int[N+1];
        friends = new int[N+1];

        for (int i = 1; i <= N; i++) {
            candies[i] = Integer.parseInt(st.nextToken());
            roots[i] = i;
            friends[i] = 1;
        }


        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            union(a, b);
        }

        for (int i = 1; i <= N; i++) {
            findSet(i);
        }

        boolean[] visited = new boolean[N+1];

        List<Integer> friendSumList = new ArrayList<>();
        List<Integer> candySumList = new ArrayList<>();

        friendSumList.add(0);
        candySumList.add(0);
        int listsSize = 0;

        for (int i = 1; i <= N; i++) {
            int root = roots[i];
            if(!visited[root]){
                visited[root] = true;
                friendSumList.add(friends[root]);
                candySumList.add(candies[root]);
                listsSize++;
            }
        }
           
        int answer = 0;
        int[] DP = new int[K];
        for (int i = 1; i <= listsSize; i++) {
            for (int j = K-1; j >=0; j--) {
                if(j >= friendSumList.get(i))
                    DP[j] = Math.max(DP[j], DP[j - friendSumList.get(i)] + candySumList.get(i));
                    answer = Math.max(DP[j], answer);
            }
        }
        System.out.println(answer);
    }

    static int findSet(int a){
        if(roots[a] == a)
            return a;
        return roots[a] = findSet(roots[a]);
    }


    static boolean union(int a, int b){
        int aRoot = findSet(a);
        int bRoot = findSet(b);

        if(aRoot == bRoot) return false;
        candies[aRoot] += candies[bRoot];
        friends[aRoot] += friends[bRoot];
        roots[bRoot] = aRoot;
        return true;
    }
}
