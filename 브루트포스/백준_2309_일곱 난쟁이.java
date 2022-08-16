import java.io.*;
import java.util.*;


public class Main {
    static int[] arr;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int len = 9;
        int ans_len  = 7;
        arr = new int[len];

        int sum = 0;
        for(int i = 0; i < len; i++){
            arr[i] = Integer.parseInt(br.readLine());
            sum += arr[i];
        }

        loop:
        for(int i = 0 ; i < len-1; i++){
            for(int j = i+1; j < len; j++){
                if(sum - arr[i] - arr[j] == 100){
                    arr[i] = 0;
                    arr[j] = 0;
                    Arrays.sort(arr);
                    for(int k = 2; k < len; k++){
                        System.out.println(arr[k]);
                    }
                    break loop;
                }
            }
        }


    }
}