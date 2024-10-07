import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.Queue;
import java.util.LinkedList;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int [] q = new int [2 * n];
        for (int i = 1; i <= n; i++) {
            q[i] = i;
        }

        int first_index = 1;
        int last_index = n;

        while (n-- > 1) {
            first_index++;
            q[last_index + 1] = q[first_index];
            last_index++;
            first_index++;

        }
        System.out.println(q[first_index]);

    }
}