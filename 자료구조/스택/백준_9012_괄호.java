import java.io.*;
import java.util.*;

public class 백준_9012_괄호 {
    static Stack<Character> stack;
    static boolean stack_check(String str){
        for(int i = 0; i < str.length(); i++){
            char c = str.charAt(i);

            if(c == '(') stack.add(c);
            else{
                if(stack.isEmpty()) return false;
                else{
                    stack.pop();
                }
            }
        }
        if(!stack.isEmpty()) return false;
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for(int t = 0; t < T; t++){
            stack = new Stack<>();
            String str = br.readLine();

            String ans = (stack_check(str)) ? "YES" : "NO";
            System.out.println(ans);

        }
    }
}
