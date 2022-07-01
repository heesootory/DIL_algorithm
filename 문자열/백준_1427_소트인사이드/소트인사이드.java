import java.util.*;

public class Main{

    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[] arr = new int[10];
        Arrays.fill(arr, 10);
        int i = 0;

        while(n >= 1){
            arr[i] = n % 10;
            i++;
            n /= 10;
        }
        Arrays.sort(arr);
        for(int j = i-1; j >= 0; j--){
            System.out.print(arr[j]);
        }

    }
}