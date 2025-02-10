import java.util.StringTokenizer;

import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int max = 1000000;
        int min = 1;
        int n = Integer.parseInt(br.readLine());

        StringTokenizer stz = new StringTokenizer(br.readLine(), " ");

        for (int i = 0; i < n; i++) {
            int m = Integer.parseInt(stz.nextToken());

            if (m < max) {
                max = m;
            }
            if (m > min) {
                min = m;
            }
        }
        System.out.println(min * max);
    }

}
