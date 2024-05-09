package Z_ETC;

import java.io.*;
import java.util.StringTokenizer;

class Solution_2115_벌꿀채취_최효빈 {

    static int[][] selected;
    static int[][] map;
    static int N,M,C;
    static int answer;
    static int[] max = new int[3];


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        for(int t=1; t<=T; t++) {
            //input
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());
            selected = new int[N][N];
            map = new int[N][N];
            answer = 0;
            for(int i=0; i<N; i++) {
                st = new StringTokenizer(br.readLine());
                for(int j=0; j<N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            //solve
            recur(1,0);

            //output
            bw.write("#" + t+ " " + answer +'\n');
        }
        bw.close();
    }

    static void comb(int cnt, int r, int c, int sum, int price) {

        if(sum > C) {
            return;
        }

        max[cnt] = Math.max(max[cnt],price);

        if(c>=N) return;
        if(selected[r][c] != cnt) return;
        comb(cnt,r,c+1,sum + map[r][c],price + map[r][c]* map[r][c]);
        comb(cnt,r,c+1, sum, price);
    }


    static void setSelect(int cnt, int r, int c) {
        for(int i=0; i<M; i++) {
            if(selected[r][c+i]==0) selected[r][c+i] = cnt;
            else selected[r][c+i] = 0;
        }
    }

    static void setMax() {
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                if(selected[i][j]==1) {
                    if(max[1]!=0) continue;
                    comb(1,i,j,0,0);
                }
                else if(selected[i][j]==2) {
                    if(max[2]!=0) continue;
                    comb(2,i,j,0,0);
                }
            }
        }
    }

    static void recur(int cnt, int idx) {
        if(cnt==3) {
            max[1] = max[2] = 0;
            setMax();
            answer = Math.max(answer, max[1] + max[2]);
            return;
        }

        if(idx>=N*N) return;

        int r = idx/N;
        int c = idx%N;

        if(c+M>N) {
            recur(cnt,(idx+M) - (idx+M)%N);
        }
        else {

            setSelect(cnt,r,c);
            recur(cnt+1,idx+M);
            setSelect(cnt,r,c);

            recur(cnt,idx+1);
        }
    }

}