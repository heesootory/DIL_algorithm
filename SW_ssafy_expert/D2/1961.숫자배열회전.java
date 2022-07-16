import java.util.*;

public class Solution {
    public static int[][] pivot_90degree(int[][] arr, int n){       // 매개변수로 받는 배열을 무조건 오른족으로 90도 회전시킨 배열을 return 하는 함수.
        int[][] arr2 = new int[n][n];
        for(int i = 0 ; i < n; i++){
            for(int j = 0; j < n; j++){
                arr2[i][j] = arr[(n-1)- j][i];
            }
        }
        return arr2;
    }

    public static void main(String[] args) throws Exception {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        int _case = 1;

        while(t-- > 0) {
            int n = s.nextInt();
            int[][] arr = new int[n][n];
            int[][] arr_pivot_90 = new int[n][n];
            int[][] arr_pivot_180 = new int[n][n];
            int[][] arr_pivot_270 = new int[n][n];

            for(int i = 0; i< n; i++){
                for(int j = 0; j< n; j++){
                    arr[i][j] = s.nextInt();
                }
            }
            arr_pivot_90 = pivot_90degree(arr, n);
            arr_pivot_180 = pivot_90degree(arr_pivot_90, n);
            arr_pivot_270 = pivot_90degree(arr_pivot_180, n);

            System.out.println("#"+_case);
            for(int i = 0; i < n; i++){
                for(int j = 0; j < n; j++) System.out.print(arr_pivot_90[i][j]);
                System.out.print(" ");
                for(int j = 0; j < n; j++) System.out.print(arr_pivot_180[i][j]);
                System.out.print(" ");
                for(int j = 0; j < n; j++) System.out.print(arr_pivot_270[i][j]);
                System.out.println();
            }

            _case++;
        }
    }
}