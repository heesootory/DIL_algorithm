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

            int city = Integer.parseInt(st.nextToken());
            int[] city_arr = new int[city];
            int d = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < city; i++) city_arr[i] = Integer.parseInt(st.nextToken());

            int idx = 0;
            int cnt = 0;
            while(idx < city){
                boolean check = false;
                int jump = 0;

                for(int i = idx; i < idx + d; i++) {
                    jump++;
                    if(city_arr[i] == 1){
                        check = true;
                        break;
                    }
                }

                idx += jump;
                if(!check) cnt++;

            }

            System.out.printf("#%d %d\n", t, cnt);

        }

    }
}
