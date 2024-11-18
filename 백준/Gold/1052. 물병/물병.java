import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt(); // 물병의 초기 개수
        int K = scanner.nextInt(); // 목표 물병 개수
        int addedBottles = 0;      // 추가한 물병 수

        // 물병의 개수가 K 이하가 될 때까지 반복
        while (Integer.bitCount(N) > K) {
            N++;                 // 물병을 하나 추가
            addedBottles++;      // 추가한 물병 수 증가
        }

        System.out.println(addedBottles); // 최소 추가 물병 수 출력
        scanner.close();
    }
}
