import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        int _case = 1;
        while(t-- > 0) {

            int n = s.nextInt();
            String str = "";
            String c = "";
            int k = 0;
            for(int i = 0; i< n; i++) {
                c = s.next();
                k = s.nextInt();
                for(int j = 0; j < k; j++) {
                    str += c;
                }
            }
            int cnt = 0;

            System.out.println("#" + _case);
            for(int i = 0; i< str.length(); i++) {
                System.out.print(str.charAt(i));
                cnt++;
                if(cnt == 10) {
                    System.out.println();
                    cnt = 0;
                }
            }
            _case++;
            System.out.println();
        }

    }
}
