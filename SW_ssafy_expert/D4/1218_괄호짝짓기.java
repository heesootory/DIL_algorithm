import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for(int t = 1; t <= 10; t++){
            Stack<Character> stack = new Stack<>();
            int n = Integer.parseInt(br.readLine());

            String str = br.readLine();

            boolean check = true;
            for(int i = 0; i < n; i++){
                char c = str.charAt(i);
                if(c == '(' || c == '{' || c == '[' || c == '<') stack.add(c);
                else if(c == ')') check = (stack.pop() == '(');
                else if(c == '}') check = (stack.pop() == '{');
                else if(c == ']') check = (stack.pop() == '[');
                else if(c == '>') check = (stack.pop() == '<');

                if(!check) break;
            }
            int ans = (check) ? 1 : 0;

            System.out.println("#" + t + " " + ans);


        }
    }
}
