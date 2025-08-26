import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            int n = Integer.parseInt(br.readLine());
            int count = 0;

            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                int cx = Integer.parseInt(st.nextToken());
                int cy = Integer.parseInt(st.nextToken());
                int r = Integer.parseInt(st.nextToken());

                // 제곱 거리를 long 타입으로 계산하여 오버플로우 방지
                long radiusSq = (long) r * r;
                long distStartSq = (long) Math.pow(x1 - cx, 2) + (long) Math.pow(y1 - cy, 2);
                long distEndSq = (long) Math.pow(x2 - cx, 2) + (long) Math.pow(y2 - cy, 2);
                
                // 출발점과 도착점의 포함 여부를 boolean으로 저장
                boolean isStartInside = distStartSq < radiusSq;
                boolean isEndInside = distEndSq < radiusSq;
                
                // 두 점의 상태가 다를 경우 (XOR 연산과 동일) 카운트 증가
                if (isStartInside != isEndInside) {
                    count++;
                }
            }
            sb.append(count).append('\n');
        }
        System.out.print(sb);
    }
}