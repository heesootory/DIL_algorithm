import java.io.*;
import java.util.*;

/**
 * 문자열 정렬
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        int[] wifi = new int[N-1];

        for(int n = 0; n < N; n++){
            st = new StringTokenizer(br.readLine());
            arr[n] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        int min = Integer.MAX_VALUE;
        int sum = 0;
        for(int i = 0; i< arr.length-1; i++){
            wifi[i] = arr[i+1] - arr[i];
            min = Math.min(min, wifi[i]);
            sum += wifi[i];
        }

        int left = min;
        int right = sum;
        int mid = 0;
        while(left <= right){
            mid = (left + right)/2;

            int cnt = 0;
            int part_sum = 0;
            for(int i =0; i < wifi.length; i++){
                if((part_sum + wifi[i]) >= mid){
                    cnt++; part_sum = 0;
                }
                else part_sum += wifi[i];
            }
            if(part_sum >= mid) cnt++;

//            System.out.println("mid " + mid);
////            System.out.println("cnt " + cnt);

            int norm = C-1;
            if(cnt < norm) right = mid - 1;
            else left = mid + 1;

        }
        System.out.println(right);
    }
}