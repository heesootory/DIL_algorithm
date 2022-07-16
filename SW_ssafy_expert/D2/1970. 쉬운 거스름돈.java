import java.util.*;

public class Solution {

    public static void main(String[] args) throws Exception {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        int _case = 1;

        int[] money = {50000, 10000, 5000, 1000, 500, 100, 50, 10};

        while(t-- > 0) {
            int[] num = new int[8];
            int n = s.nextInt();

            for(int i = 0; i< money.length; i++){
                num[i] = n / money[i];
                n %= money[i];
            }
            System.out.println("#" + _case +" ");
            for(int i : num) System.out.print(i + " ");
            System.out.println();

            _case++;
        }
    }
}