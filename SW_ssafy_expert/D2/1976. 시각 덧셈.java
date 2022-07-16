import java.util.*;

public class Solution {

    public static void main(String[] args) throws Exception {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        int _case = 1;

        while(t-- > 0) {
            int h1 = s.nextInt();
            int m1 = s.nextInt();
            int h2 = s.nextInt();
            int m2 = s.nextInt();

            int h = h1+h2;
            int m = m1 + m2;
            if(m >= 60) {
                h++; m -= 60;
            }
            if(h >= 12) h-=12;

            System.out.println("#" + _case + " " + h + " " + m);



            _case++;
        }
    }
}