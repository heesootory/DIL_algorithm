import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args)throws IOException {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[] arr = new int[100];
        for(int i = 0; i < n; i++) arr[i] = s.nextInt();

        int sum = 0;
        for(int i = n-1; i>0; i--){
            if(arr[i-1] >= arr[i]){
                sum += (arr[i-1] - (arr[i] - 1));
                arr[i-1] = arr[i] - 1;
            }
        }
        System.out.println(sum);
    }
}