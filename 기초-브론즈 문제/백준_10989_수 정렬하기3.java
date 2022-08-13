public import java.io.*;
import java.util.*;

/**
 * 카운팅 정렬을 이용한 정렬
 */

public class Main {
    static int min = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        int max = 0;
        for(int i =0 ; i< n; i++){
            arr[i] = Integer.parseInt(br.readLine());
            if(max < arr[i]) max = arr[i];
        }

        int[] count_arr = new int[max+1];

        // 카운팅 정렬
        for(int i : arr) count_arr[i]++;

        // 누적합
        for(int i = 1; i < count_arr.length; i++){
            count_arr[i] += count_arr[i-1];
        }

        int[] sorted_arr = new int[n];

        for(int i = n-1; i>= 0; i--){
            int idx = --count_arr[arr[i]];
            sorted_arr[idx] = arr[i];
        }

        for(int i : sorted_arr) sb.append(i + "\n");
        System.out.println(sb);

    }
} 백준_10989_수 정렬하기3 {
    
}
