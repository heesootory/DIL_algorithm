import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int test = Integer.parseInt(br.readLine());

        for(int t = 0; t < test; t++){
            int[] a_arr = new int[5];
            int[] b_arr = new int[5];

            st = new StringTokenizer(br.readLine());
            int a_cnt = Integer.parseInt(st.nextToken());

            for(int a = 0; a < a_cnt; a++) {
                int x = Integer.parseInt(st.nextToken());
                a_arr[x]++;
            }

            st = new StringTokenizer(br.readLine());
            int b_cnt = Integer.parseInt(st.nextToken());

            for(int b = 0; b < b_cnt; b++) {
                int x = Integer.parseInt(st.nextToken());
                b_arr[x]++;
            }

            boolean check = false;
            int i = 4;
            for(; i > 0; i--){
                if(a_arr[i] != b_arr[i]) {
                    check = true;
                    break;
                }
            }

            String ans = "";
            if(check) ans = (a_arr[i] > b_arr[i]) ? "A" : "B";
            else ans = "D";

            System.out.println(ans);

        }


    }
}
