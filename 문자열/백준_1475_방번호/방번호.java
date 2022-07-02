import java.util.*;

public class Main{

    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[] arr = new int[10];
        while(n >= 1){
            int i = n % 10;
            if(i == 9) i = 6;
            arr[i]++;
            n /= 10;
        }
        arr[6] = (arr[6] % 2 == 0 ) ? arr[6] / 2 : arr[6] / 2 + 1;
        int max = 0;
        for(int i : arr) if(i > max) max = i;
        System.out.println(max);

    }
}