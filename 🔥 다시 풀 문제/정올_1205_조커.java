import java.io.*;
import java.util.*;


public class Main {
    static int n;
    static boolean[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        arr = new boolean[1000002];
        int joker = 0;
        int num_cnt = 0;
        int max_num = Integer.MIN_VALUE;

        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < n; i++){
            int x = Integer.parseInt(st.nextToken());
            if(x == 0) joker++;
            else {
                num_cnt++;
                arr[x] = true;
                if(x > max_num) max_num = x;
            }
        }

        if(num_cnt == 0) {
            System.out.println(joker); return;
        }

        int origin = joker;
        int max = 0;
        for(int i = 0; i <= max_num; i++){
            if(arr[i]){
                int idx = i;        // 시작 넘버
                joker = origin;
                int cnt = 1;
                while(idx <= 1000000) {
                    if (!arr[++idx]) {
                        if (joker == 0) break;
                        else joker--;
                    }
                    cnt++;
                }
                max = Math.max(max, cnt);
            }
        }
        System.out.println(max);



    }
}