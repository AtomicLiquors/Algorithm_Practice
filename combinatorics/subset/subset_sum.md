### 부분집합의 합
유한 개의 정수로 이루어진 집합에 대해,  
그 부분집합 중 원소의 총합이 0인 것이 있는지 알아내는 문제.

```java
static int N, S, totalCnt;
    static int[] input;
    static boolean isSelected[] = new boolean[N+1];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        S = sc.nextInt();
        input = new int[N];
        isSelected = new boolean[N];

        for (int i = 0; i < N; i++) {
            input[i] = sc.nextInt();
        }
        subset(0, 0);
    }


    static void subset(int cnt, int sum){
        if(cnt == N) {
            /*for (int i = 0; i < N; i++) {
                if(isSelected[i]) sum += input[i];
            }*/
            if(sum==S){
                totalCnt++;
                for (int i = 0; i < N; i++) {
                    if(isSelected[i]) System.out.print(input[i] + "\t");
                }
                System.out.println();
            }
            return;
        }

        isSelected[cnt] = true;
        subset(cnt+1, sum + input[cnt]);
        isSelected[cnt] = false;
        subset(cnt+1, sum);
    }
```

<br>

특징 :   
주석처리한 것처럼 N번째에 도달했을 때 sum에다 원소를 일일이 더하는 게 아니라,   
sum 매개변수를 따로 만들고 & 재귀호출할 때 원소의 값을 더해서 전달했다.  
