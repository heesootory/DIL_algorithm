import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int L = Integer.parseInt(br.readLine());
        int[] cake = new int[L+1];              // 조각마다 예약 번호를 붙힐 배열
        int n = Integer.parseInt(br.readLine());

        int fake_max = 0;
        int fake_num = 0;
        for(int i = 1; i <= n; i++){
            int cnt = 0;
            st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int q = Integer.parseInt(st.nextToken());
            for(int j = p; j <= q; j++) {
                if(cake[j] == 0) {      // 케익이 예약 안되어 있을 때만
                    cake[j] = i;        // i번째 사람으로 케익에 기록
                }
            }

            int num = q - p + 1;        // 신청한 케익 조각 수 = 기대 갯수

            if(fake_max < num) {
                fake_max = num;
                fake_num = i;           // 기대한 조각이 제일 많은 사람 기록
            }
        }

        int[] hasCake = new int[n+1];           // 사람마다 몇개의 조각을 받을 수 있는지 배열
        for(int i = 1; i< L+1; i++) hasCake[cake[i]]++;
        int real_max = 0;
        int ans = 0;
        for(int i =1; i< hasCake.length; i++) {     // 실제 받는 조각의 max
            if(hasCake[i] > real_max) {
                ans = i;
                real_max = hasCake[i];
            }
        }

        System.out.println(fake_num);
        System.out.println(ans);

    }
}
