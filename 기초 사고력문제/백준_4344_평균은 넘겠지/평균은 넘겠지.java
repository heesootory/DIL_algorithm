import java.util.*;

public class Main{

    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int m = s.nextInt();
        while(m-- > 0){
            int n = s.nextInt();
            int[] arr = new int[n];
            int ever = 0;
            for(int i = 0; i < n; i++) {
                arr[i] = s.nextInt();
                ever += arr[i];
            }
            ever /= n;
            int cnt = 0;
            for(int i = 0; i < arr.length; i++)
                if(arr[i] > ever) cnt++;
            System.out.format("%.3f%%\n", (float)cnt*100/n);
        }
    }
}