    import java.io.BufferedReader;
    import java.io.IOException;
    import java.io.InputStreamReader;

    import java.util.StringTokenizer;


    public class Main {
        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            int N = Integer.parseInt(br.readLine());
            int [] arr = new int [N];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }


            int num = 0;
            int count = 0;
            int a = 0;

            while(num <= arr[N-1]){

                if ( a < N - 1 && (num + 1) == arr[a] && (num + 2) == arr[a+1]) {
                    System.out.println(-1);
                    return;
                } else if ( a < N && (num + 2) == arr[a] ) {
                    num += 3;
                    a += 1;
                    count += 2;
                } else if ( a < N && (num + 1 == arr[a]) ) {
                    num += 2;
                    a += 1;
                    count += 1;
                } else {
                    num += 2;
                    count += 1;
                }
            }
            System.out.println(count);
        }

    }