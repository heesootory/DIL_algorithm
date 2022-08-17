import java.io.*;
import java.util.*;

public class 백준_2810_컵홀더 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String str = br.readLine();

        int s_cnt = 0;
        int l_cnt = 0;

        for(int i = 0; i< str.length(); i++){
            if(str.charAt(i) == 'S') s_cnt++;
            else l_cnt++;
        }

        int person_cnt = s_cnt + l_cnt;
        int cup_cnt = s_cnt + l_cnt/2 + 1;
        int ans = (person_cnt < cup_cnt) ? person_cnt : cup_cnt;

        System.out.println(ans);

    }
}
