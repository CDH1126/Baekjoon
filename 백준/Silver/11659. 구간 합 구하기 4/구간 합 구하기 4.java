import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        long[] sum = new long[n + 1]; // 누적 합 배열 (기존 sum 변수를 배열로 재활용)

        // 두 번째 줄: 수열 입력 및 누적 합 계산
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            sum[i + 1] = sum[i] + arr[i]; // 누적 합 저장
        }

        // 쿼리 처리
        for (int j = 0; j < m; j++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            long result = sum[b] - sum[a - 1]; // 구간 합 계산
            System.out.println(result);
        }
    }
}