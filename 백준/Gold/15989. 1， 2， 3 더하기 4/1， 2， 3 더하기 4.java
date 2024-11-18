import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] dp = new int[10001];
        for (int i = 0; i < 10001; i++) {
            dp[i] = 1;
        }
        for (int i = 2; i < 10001; i++) {
            dp[i] += dp[i-2];
        }
        for (int i = 3; i < 10001; i++) {
            dp[i] += dp[i-3];
        }

        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            System.out.println(dp[n]);
        }

    }

}
