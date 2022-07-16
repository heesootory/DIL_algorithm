import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {

        Scanner s = new Scanner(System.in);

        int t = s.nextInt();
        int _case = 1;
        while(t-- > 0){
            int[] arr = new int[10];
            for(int i = 0; i< arr.length; i++) arr[i] = s.nextInt();
            Arrays.sort(arr);
            double sum = 0;
            for(int i =1; i< arr.length -1; i++) sum += arr[i];
            System.out.println("#" + _case +" "+ + Math.round(sum / 8));
            _case++;
        }
    }
}