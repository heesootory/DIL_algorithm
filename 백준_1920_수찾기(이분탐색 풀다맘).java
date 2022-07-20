import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;


public class test {

    public static void main(String[] args) throws IOException {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[] arr = new int[n];

        for(int i =0; i< n; i++) arr[i] = s.nextInt();
        Arrays.sort(arr);

        int m = s.nextInt();
        int[] ans_arr = new int[m];

        for(int i =0; i< m; i++) {
            int a = s.nextInt();
            if(a > arr[arr.length-1]) ans_arr[i] = 0;
            else{
                boolean check = false;

                int left = 0, right = arr.length-1;
                int mid = right;

                while(left < right){
                    if(mid == a) {
                        ans_arr[i] = 1;
                        break;
                    }
                    else{
                        
                    }
                }


            }
        }

    }
}
