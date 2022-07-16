import java.util.*;

public class Main{
    public static void main(String[] args) throws Exception {

        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        int _case = 1;

        while(t-- > 0){
            int n = s.nextInt();
            int[][] arr = new int[n][];
            for(int i =0; i < n; i++) arr[i] = new int[i+1];

            for(int i = 0; i < n; i++){
                for(int j = 0; j < arr[i].length; j++){
                    if(j == 0 || j == arr[i].length-1) arr[i][j] = 1;
                    else arr[i][j] = arr[i-1][j] + arr[i-1][j-1];
                }
            }

            System.out.println("#" + _case++);
            for(int[] i : arr){
                for(int j : i) System.out.print(j + " ");
                System.out.println();
            }
        }



    }
}