import java.io.*;
import java.util.*;

public class Main{
    public static int n;
    public static boolean check(int[] arr, int evg){
        for(int i =0; i< n; i++){
            if(arr[i] < evg) return false;
        }
        return true;
    }

    public static void main(String[] args)throws IOException {
        Scanner s = new Scanner(System.in);
        n = s.nextInt();
        int[] arr = new int[n];
        long sum = 0;
        int max = 0;
        for(int i = 0; i< n; i++){
            arr[i] = s.nextInt();
            if(arr[i] > max) max = arr[i];
            sum += arr[i];
        }

        Arrays.sort(arr);

        int total = s.nextInt();
        int evg = total/n;

        if(sum <= total) System.out.println(max);
        else if(check(arr, evg)) System.out.println(evg);
        else{
            int start = 0;
            int end = 0;
            int mid = 0;
            // start, end 정하기
            for(int i = 0; i < n-1 ;i++){
                int norm1 = arr[i];
                int norm2 = arr[i+1];
                int sum1 = 0;
                int sum2 = 0;
                for(int j = 0; j < n; j++){
                    if(arr[j] > norm1) sum1 += norm1;
                    else sum1 += arr[j];
                    if(arr[j] > norm2) sum2 += norm2;
                    else sum2 += arr[j];
                }
                if(sum1 <= total && total <= sum2){
                    start = norm1;
                    end = norm2;
                }
            }
            while(end - start > 1){
                int max_sum = 0;
                mid = (start + end) / 2;

                for(int i = 0; i< n; i++){
                    if(arr[i] > mid) max_sum += mid;
                    else max_sum += arr[i];
                }
                if(max_sum > total) end = mid;
                else start = mid;
            }
            System.out.println(start);
        }
    }
}