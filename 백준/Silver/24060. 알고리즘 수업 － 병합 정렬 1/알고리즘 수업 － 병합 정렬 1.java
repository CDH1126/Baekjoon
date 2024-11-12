
import java.io.*;

import java.util.Arrays;
import java.util.StringTokenizer;


public class Main {
    int [] a;
    static int [] tmp;
    static int result = -1;
    static int cnt = 0;
    static int k;

    public static void main(String[] args) throws IOException  {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        int [] arr = new int[n];
        tmp = new int[n];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        merge_sort(arr, 0, n-1);

        System.out.println(result);
    }

    static void merge_sort(int a[], int p, int r) {
        if (cnt > k) return;
        if (p < r) {
            int q = (p + r) /2;
            merge_sort(a, p, q);
            merge_sort(a, q+1, r);
            merge(a, p, q, r);
        }
    }

    static void merge(int Array[], int p, int q, int r) {
        int i = p;
        int j = q + 1;
        int t = 0;

        while (i <= q && j <= r) {
            if (Array[i] < Array[j]) {
                tmp[t++] = Array[i++];
            } else {
                tmp[t++] = Array[j++];
            }

        }

        while (i <= q) {
            tmp[t++] = Array[i++];
        }

        while (j <= r) {
            tmp[t++] = Array[j++];
        }

        i = p;
        t = 0;
        while (i <= r) {
            cnt++;

            if (cnt == k) {
                result = tmp[t];
                break;
            }

            Array[i++] = tmp[t++];
        }

    }

}

