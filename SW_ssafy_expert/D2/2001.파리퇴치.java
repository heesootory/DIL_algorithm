import java.util.*;

public class Solution {
    public static int flapper(int[][] arr, int a, int b, int m){
        int sum = 0;
        for(int i = a; i < a+m; i++){
            for(int j = b; j < b+m; j++){
                sum += arr[i][j];
            }
        }

        return sum;
    }

    public static void main(String[] args) throws Exception {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        int _case = 1;

        while(t-- > 0){
            int n = s.nextInt();
            int m = s.nextInt();

            int[][] arr = new int[n][n];
            for(int i = 0; i< n; i++){
                for(int j = 0; j < n; j++){
                    arr[i][j] = s.nextInt();
                }
            }
            int max = 0;
            for(int i = 0; i < n - (m - 1); i++){
                for(int j = 0; j < n - (m - 1); j++){
                    int sum = flapper(arr, i, j , m);
                    if(max < sum) max = sum;
                }
            }
            System.out.println("#" + _case + " " + max);
            _case++;
        }




    }
}