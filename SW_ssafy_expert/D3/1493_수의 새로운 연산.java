public class 1493_수의 새로운 연산 {
    
}
import java.io.*;
import java.util.*;

public class Main {
    static int[] numTo_xy(int n){
        int i = 0;
        int[] arr = new int[2];
        while(true){
            for(int k = 1; k< 10000; k++){
                for(int x = 1, y = k; x <= k; x++, y--){
                   i++;
                   if(i == n){
                       arr[0] = x;
                       arr[1] = y;
                       return arr;
                   }
                }
            }
        }
    }
    static int xy_Tonum(int x, int y){
        int i = 0;
        while(true){
            for(int k = 1; k< 10000; k++){
                for(int a = 1, b = k; a <= k; a++, b--){
                    i++;
                    if(a == x && b == y) return i;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int test = Integer.parseInt(br.readLine());

        for(int t = 1; t <= test; t++){

            st = new StringTokenizer(br.readLine());

            int p = Integer.parseInt(st.nextToken());
            int q = Integer.parseInt(st.nextToken());

            int[] ans_arr = {numTo_xy(p)[0] + numTo_xy(q)[0], numTo_xy(p)[1] + numTo_xy(q)[1]};
            System.out.println("#" + t + " " + xy_Tonum(ans_arr[0], ans_arr[1]));

        }

    }
}