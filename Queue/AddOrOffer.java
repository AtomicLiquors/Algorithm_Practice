package Queue;

import java.util.Queue;
import java.util.Scanner;
import java.util.concurrent.ArrayBlockingQueue;

public class AddOrOffer {
    public static void main(String[] args) {
        /* 크기 제한을 가진 'ArrayBlockingQueue'를 이용해 최대 크기가 5인 큐를 생성합니다. */
        Queue<Integer> que = new ArrayBlockingQueue<>(5);
        Scanner sc = new Scanner(System.in);
        System.out.println("1 이상의 정수를 입력해서 큐에 저장해 주세요.");
        System.out.println("- 큐의 최대 크기는 5입니다.");
        System.out.println("- -1을 입력하면 큐에서 첫 번째 원소를 제거합니다.");
        System.out.println("- 0을 입력하면 큐를 출력하고, 프로그램을 종료합니다.");

        while(true){
            /* 스캐너로 정수를 입력받아 큐에 삽입합니다. */
            int input = sc.nextInt();

            /* -1을 입력한 경우 큐의 맨 첫번째 원소를 제거합니다. */
            if(input == -1){
                int removedItem = que.poll();
                System.out.printf("큐에서 원소 제거됨 : %d\n", removedItem);
            }

            /* 0을 입력한 경우 반복문을 종료합니다. */
            if(input == 0)
                break;

            que.add(input);
        }

        System.out.println("큐 상태 : " + que);
    }
}

class Storage {
    static void addTenTimes(Queue que) {
        /* 1부터 10까지 add로 큐에 집어넣는 연산을 실행합니다. */
        for (int i = 1; i <= 10; i++) {
            que.add(i);
        }
    }

    static void offerTenTimes(Queue que) {
        /* 1부터 10까지 offer로 큐에 집어넣는 연산을 실행합니다. */
        for (int i = 1; i <= 10; i++) {
            que.offer(i);
        }
    }

    static void addTenTimesWithTryCatch(Queue que) {
        /* 1부터 10까지 add로 큐에 집어넣는 연산을 실행합니다. */
        try {
            for (int i = 1; i <= 10; i++) {
                que.add(i);
            }
        } catch (IllegalStateException e) {
            System.err.println("에러 : 큐가 가득 찼습니다!");
        }
    }

    static void offerTenTimesWithResult(Queue que) {
        /* 1부터 10까지 offer로 큐에 집어넣는 연산을 실행합니다. */

        for (int i = 1; i <= 10; i++) {
            boolean result = que.offer(i);
            if (!result) {
                System.err.println("에러 : 큐가 가득 찼습니다!");
                break;
            }
        }
    }
}