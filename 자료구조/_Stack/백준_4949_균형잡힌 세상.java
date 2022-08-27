import java.io.*;
import java.util.*;


public class 백준_4949_균형잡힌 세상 {
    static Stack<Character> stack;
    static boolean stack_check(String str){
        for(int i = 0; i < str.length(); i++){
            char c = str.charAt(i);

            if(c == '(' || c == '[') stack.add(c);
            else if(c == ')'){
                if(stack.isEmpty() || stack.pop()!= '(') return false;
            }
            else if(c == ']'){
                if(stack.isEmpty() || stack.pop() != '[') return false;
            }
        }
        if(!stack.isEmpty()) return false;

        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        String str;

        while(true){
            str = br.readLine();

            if(str.equals(".")) break;

            stack = new Stack<>();

            String ans = (stack_check(str)) ? "yes" : "no";
            System.out.println(ans);

        }
    }
}
