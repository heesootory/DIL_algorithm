import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int test = Integer.parseInt(br.readLine());

        for(int t = 1; t <= test; t++){

            st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());

            int[] guest = new int[n];       // 손님이 오는 시간을 저장할 배열
            int max_time = 0;               // 손님이 오는 가장 마지막 시간을 기록
            for(int i = 0; i < n ; i++){
                guest[i] = Integer.parseInt(st.nextToken());
                if(max_time < guest[i]) max_time = guest[i];
            }

            int[] guest_arr = new int[max_time + 1];            // 인덱스 : 시간 / 값 : 손님의 수 기록
            for(int i = 0; i < n; i++) guest_arr[guest[i]]++;       // 시간마다 손님의 수를 기록.

            //붕어빵이 시간마다 얼마나 남아있는지 배열로 만듬 -> 손님이 오는 최대시간만큼만 만들면됨.
            boolean can = true;
            if(guest_arr[0] > 0){       // 0일때는 문제에서 손님안온다고 했지만.....체크해야함...
                can = false;
            }else{
                int num = 0;
                for(int i = 1; i < guest_arr.length; i++) {
                    if(i % m == 0) num += k;            //  m시간마다 붕어빵의 갯수는 누적됨.
                    num -= guest_arr[i];                // 손님이 오는 시간에 갯수가 줄어듬
                    if(num < 0){
                        can = false;
                        break;
                    }
                }
            }

            String ans = (can) ? "Possible" : "Impossible";

            System.out.printf("#%d %s\n", t, ans);
        }

    }
}
