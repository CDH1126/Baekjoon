import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer stz = new StringTokenizer(br.readLine(), " ");
        int max = 0;
        double sum = 0.0;

        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(stz.nextToken());

            if (num > max) {
                max = num;
            }

            sum += num;
        }


        System.out.println((sum/max) * 100.0 / n);
    }
}

