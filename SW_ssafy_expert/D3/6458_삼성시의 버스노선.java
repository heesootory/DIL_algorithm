import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int test = Integer.parseInt(br.readLine());

        for(int t = 1; t <= test; t++){
            int n = Integer.parseInt(br.readLine());
            int[] a = new int[n];
            int[] b = new int[n];

            for(int i = 0; i < n; i++){
                st = new StringTokenizer(br.readLine());
                a[i] = Integer.parseInt(st.nextToken());
                b[i] = Integer.parseInt(st.nextToken());
            }

            int p = Integer.parseInt(br.readLine());
            int[] p_arr = new int[p];
            for(int i = 0; i < p; i++) p_arr[i] = Integer.parseInt(br.readLine());

            int[] ans = new int[p];
            for(int i = 0; i< p; i++) {
                int cnt = 0;
                for(int j = 0; j < n; j++){
                    if(p_arr[i] >= a[j] && p_arr[i] <= b[j]) cnt++;
                }
                ans[i] = cnt;
            }

            System.out.printf("#%d ",t);
            for(int i : ans) System.out.print(i + " ");
            System.out.println();


        }


    }
}
