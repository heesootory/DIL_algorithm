import java.io.*;
import java.util.*;
 
 
 
public class Solution {
    static int min = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
 
        int T = Integer.parseInt(br.readLine());
 
        for(int t = 1; t <= T; t++){
 
            st = new StringTokenizer(br.readLine());
 
            int n = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
 
            int water = d+1;
            int cnt = 1;
            int term = d * 2 + 1;
 
            while(water + term <= n){
                water += term;
                //System.out.println(water);
                cnt++;
            }
            // 끝에가서 아직 물을 주지 않은 꽃이 남아있다면, 분무기 하나추가.
            if(water + d < n) cnt++;
 
            System.out.println("#" + t + " " + cnt);
 
        }
 
 
    }
}