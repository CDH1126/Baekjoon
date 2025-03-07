import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int result = getMinBags(n);
        System.out.println(result);
        br.close();
    }
    
    private static int getMinBags(int n) {
        int a = n / 5;
        for (int i = a; i >= 0; i--) {
            int r = n - (i * 5);
            if (r % 3 == 0) {
                int b = r / 3;
                return i + b;
            }
        }
        return -1;
    }
}