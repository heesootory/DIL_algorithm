
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        boolean[] arr = new boolean[n];
        int[] ans_arr = new int[n];

        int cnt = 0;
        int true_cnt = 0;
        while(true_cnt < n){
            for(int i = 0; i< n; i++){
                if(!arr[i]) cnt++;
                if(cnt == k) {
                    arr[i] = true;
                    ans_arr[true_cnt] = i+1;
                    true_cnt++;
                    cnt = 0;
                }
            }
        }
        System.out.print("<");
        for(int i = 0; i<ans_arr.length; i++){
            if(i == ans_arr.length-1) System.out.print(ans_arr[i]);
            else System.out.print(ans_arr[i] + ", ");
        }
        System.out.print(">");
    }
}
