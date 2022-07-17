import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        int _case = 1;

        while(t-- > 0) {
            int a = s.nextInt();
            int b = s.nextInt();
            int n = (a < b) ? a : b;        //무조건 n이 작은 수
            int m = (a < b) ? b : a;        //무조건 m이 큰수로 맞춰서 로직은 하나로 통일 시킴
            int[] arr1 = new int[n];
            int[] arr2 = new int[m];
            if(a < b){          //작은 배열 먼저 받을때
                for(int i = 0; i<n; i++) arr1[i] = s.nextInt();
                for(int i = 0; i<m; i++) arr2[i] = s.nextInt();
            }
            else{               //큰 배열 먼저 받을때
                for(int i = 0; i<m; i++) arr2[i] = s.nextInt();
                for(int i = 0; i<n; i++) arr1[i] = s.nextInt();
            }

            //로직 하나로 통일
            int max = 0;
            for(int k = 0; k <= m- n; k++){
                int sum = 0;
                for(int i = k, j = 0; i < k + n; i++, j++){
                    sum += arr2[i] * arr1[j];
                }
                if(max < sum) max = sum;
            }

            System.out.println("#" + _case + " " + max);
            _case++;
        }
    }
}