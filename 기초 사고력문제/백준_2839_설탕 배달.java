import java.io.*;
import java.util.*;

public class Main {
    static final int big = 5;
    static final int small = 3;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        int big_max_cnt = n / big;
        int[] cnt_arr = new int[big_max_cnt+1];

        for(int i = 0; i <= big_max_cnt; i++){      // 큰 봉지에 담을 수 있는 경우의 수
            int left = n - i * big;
            int small_cnt = left / small;       // 남은 것들 작은 봉지에 담기
            left -= (small * small_cnt);
            cnt_arr[i] = (left == 0) ? (i + small_cnt) : -1;
        }

        int ans = 0;
        Arrays.sort(cnt_arr);
        for(int i : cnt_arr) {
            if (i != -1) {
                ans = i;
                break;
            }
        }
        if(ans == 0) ans = -1;
        System.out.println(ans);
    }
}
