import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int[] dp = new int[10001];

        // dp 배열 초기화
        for (int i = 0; i <= 10000; i++) {
            dp[i] = 1;
        }

        // dp 배열 채우기 (2로 나눈 경우)
        for (int i = 2; i <= 10000; i++) {
            dp[i] += dp[i - 2];
        }

        // dp 배열 채우기 (3으로 나눈 경우)
        for (int i = 3; i <= 10000; i++) {
            dp[i] += dp[i - 3];
        }

        // 입력 처리
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        // 테스트 케이스 실행
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            System.out.println(dp[n]);
        }

        sc.close();
    }
}
