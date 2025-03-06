import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[][] grid = new char[5][15];
        int[] lengths = new int[5]; // 각 줄의 길이를 저장

        // 5줄 입력 처리
        for (int i = 0; i < 5; i++) {
            String line = br.readLine();
            if (line != null && !line.isEmpty()) {
                lengths[i] = Math.min(line.length(), 15); // 최대 15자 제한
                for (int j = 0; j < lengths[i]; j++) {
                    grid[i][j] = line.charAt(j);
                }
            }
        }

        // 세로로 읽기
        StringBuilder sb = new StringBuilder();
        for (int j = 0; j < 15; j++) {
            for (int i = 0; i < 5; i++) {
                if (j < lengths[i]) { // 입력된 길이 내에서만 접근
                    sb.append(grid[i][j]);
                }
            }
        }

        System.out.println(sb.toString());
        br.close();
    }
}