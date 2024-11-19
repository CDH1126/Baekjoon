import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split("\\.");
        String integerNum = input[0];
        String decimalNum = input[1].replaceAll("0+$", ""); // 소수 끝의 0 제거

        // 분자와 분모 계산
        long numerator = Long.parseLong(integerNum + decimalNum);
        long denominator = (long) Math.pow(10, decimalNum.length());

        // 최대공약수로 약분
        long gcd = gcd(numerator, denominator);
        numerator /= gcd;
        denominator /= gcd;

        // 1~5로 분자 분배 계산
        int[] numCount = new int[5];
        int minusNum = 5;

        for (int i = 0; i < denominator; i++) {
            if (denominator - i - 1 <= numerator - minusNum) {
                numerator -= minusNum;
                numCount[minusNum - 1]++;
            } else {
                minusNum--;
                i--;
            }
        }

        // 결과 출력
        System.out.println(Arrays.toString(numCount).replaceAll("[\\[\\],]", ""));
    }

    // 최대공약수 계산 메서드
    private static long gcd(long a, long b) {
        while (b != 0) {
            long temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}
