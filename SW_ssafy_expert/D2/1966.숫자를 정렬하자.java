import java.util.*;

public class Solution {

    public static void main(String[] args) throws Exception {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        int _case = 1;

        while(t-- > 0) {
            int n = s.nextInt();
            int[] arr=  new int[n];
            for(int i =0 ;i<n;i++) arr[i] = s.nextInt();
            Arrays.sort(arr);

            System.out.print("#" + _case + " ");
            for(int i : arr) System.out.print(i + " ");
            System.out.println();
            _case++;
        }
    }
}