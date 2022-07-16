import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {

        Scanner s = new Scanner(System.in);

        int t = s.nextInt();
        int _case = 1;

        while(t-- > 0) {
            int n = s.nextInt();
            System.out.print("#" + _case++ + " ");
            if (n % 2 == 0) System.out.println(-(n / 2));
            else System.out.println(n / 2 + 1);
        }
    }
}
