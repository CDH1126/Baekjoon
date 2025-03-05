
    import java.io.BufferedReader;
    import java.io.IOException;
    import java.io.InputStreamReader;

    public class Main {
        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            String word = br.readLine();

            int [] count = new int[26];

            for (int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);

                if (ch >= 'a' && ch <= 'z') {
                    count[ch - 'a']++;
                } else if (ch >= 'A' && ch <= 'Z') {
                    count[ch-'A']++;
                }
            }


            int maxCount = 0;
            char maxch = '?';

            for (int i = 0; i < 26; i++) {
                if (count[i] > maxCount) {
                    maxCount = count[i];
                    maxch = (char) (i + 'A');
                } else if (count[i] == maxCount && maxCount > 0) {
                    maxch = '?';
                }
            }

            System.out.println(maxch);
            



        }
    }