import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;



public class Main{

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());

        double left = (double)y;
        double right = (double)x;
        double origin = Math.floor(left * 100/right);
        double ans = 0.0;
        int cnt = 0;

        if (origin >= 99) {
            System.out.println(-1);
        }
        else{
            
            while(true){
                left++; right++;
                //System.out.println(left * 100/right);
                ans = Math.floor(left * 100/right);
                //System.out.println(ans);
                cnt++;
                if(ans - origin >= 1) break;
            }
            System.out.println(cnt);
        }

    }
}