import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count; // 소수의 숫자
        while (true){
            count = 0;//카운트 초기화
            int n = sc.nextInt(); // 입력받는 값

            if(n == 0){// 0을 입력받으면 탈출
                break;
            }

            if (n == 1) { // 1을 어떻게 받을지 모르겠어서 1만 떼냈음
                System.out.println(1);
                continue;
            }

            for (int i = n+1; i < n * 2; i++) {
                if (i % 2 == 0) {//2의 배수면 다시 돌림
                    continue;
                }

                count++; // 먼저 카운트 증가

                for (int j = 2; j < Math.sqrt(n * 2); j++) { // 루트 n*2까지 진행시킴
                    if (i % j == 0) { // 소수가 아니라면 카운트를 빼고 탈출
                        count--;
                        break;
                    }
                }
            }
            
            System.out.println(count); // 총 카운트 출력
        }

    }
}