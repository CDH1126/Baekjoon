import java.io.IOException;
import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String str;

        while (true) {
            str = br.readLine();

            if (str.equals(".")) {
                break;
            }

            sb.append(solve(str)).append('\n');

        }

        System.out.println(sb);
    }

    public static String solve (String s){

        Stack<Character> stk = new Stack<>();

            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);

                if (c == '(' || c == '[') {
                    stk.push(c);
                }

                else if (c == ')') {
                    if (stk.empty() || stk.peek() != '(') {
                        return "no";
                    } else{
                        stk.pop();
                    }
                }

                else if (c == ']'){
                    if (stk.empty() || stk.peek() != '[') {
                        return "no";
                    } else{
                        stk.pop();
                    }
                }

            }

            if (stk.empty()){
                return "yes";
            } else{
                return "no";
            }

        }

    }
