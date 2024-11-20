package combinatorics.subset.examples;

public class SubsetStandard {
    static int N = 5;

    static boolean isSelected[] = new boolean[N+1];

    public static void main(String[] args) {
        subset(1);
    }


    static void subset(int cnt){
        if(cnt == N+1) {
            for (int i = 1; i <= N; i++) {
                if(isSelected[i]) System.out.print(i + " ");
            }
            System.out.println();
            return;
        }

        isSelected[cnt] = true;
        subset(cnt+1);
        isSelected[cnt] = false;
        subset(cnt+1);
    }
}
