import java.io.*;
import java.util.*;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] arr = new int[10];

        for(int t = 0; t < 10; t++)
            arr[t] = Integer.parseInt(br.readLine());

        int sum = 0;
        int i = 0;
        for(; i < 10; i++){
            sum+= arr[i];
            if(sum >= 100) break;
        }
        
        if(sum < 100) System.out.println(sum);
        else{
            int x = sum;
            int y = sum - arr[i];

            int ans = (Math.abs(x - 100) <= Math.abs(y - 100)) ? x : y;
            System.out.println(ans);
        }


    }
}
