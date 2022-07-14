import java.util.*;

class Solution{
    public static void main(String[] args) throws Exception {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();

        for(int i = 0; i< n; i++){
            boolean same = true;
            String str = s.next();
            int len = str.length();
            for(int a = 0, b = len-1; a< len; a++, b--){
                if(str.charAt(a) != str.charAt(b)) same = false;
            }
            int ans = (same) ? 1 : 0;
            System.out.println("#"+(i+1) + " " + ans);
        }
    }
}
