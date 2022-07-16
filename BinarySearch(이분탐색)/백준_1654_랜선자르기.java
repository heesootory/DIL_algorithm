import java.util.*;

public class Main{
    public static void main(String[] args) throws Exception {
        Scanner s = new Scanner(System.in);

        int k = s.nextInt();
        int n = s.nextInt();

        int[] arr = new int[k];
        for(int i = 0 ; i< k; i++) arr[i] = s.nextInt();
        Arrays.sort(arr);

        long small = 1;
        long big = arr[k-1];            //입력받은 수들 중 가장 큰수.
        long mid = big;                 //제일 큰수로 먼저 검사 가능.

        while(small != mid){
            long cnt = 0;
            for(int i : arr) cnt += (i / mid);

            if(cnt < n) big = mid ;
            else small = mid;

            mid = (small + big) / 2;
        }
        System.out.println(mid);
    }
}