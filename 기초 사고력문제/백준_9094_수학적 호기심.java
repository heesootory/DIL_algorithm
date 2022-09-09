import java.io.*;
import java.util.*;


public class Main {
    static int T;
    static int n, m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        T = Integer.parseInt(br.readLine());

        for(int i = 0; i < T; i++){
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());

            double ans = 0;
            int ans2 = 0;
            int cnt = 0;
            for(int a = 1; a < n; a++){
                for(int b = a+1; b < n; b++){
                    ans = (a*a + b*b + m)/(double)(a*b);
                    ans2 = (a*a + b*b + m)/(a*b);

                    if(ans == ans2) cnt++;
                }
            }

            System.out.println(cnt);
        }


    }
}

