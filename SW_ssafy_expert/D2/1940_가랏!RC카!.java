import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int test = Integer.parseInt(br.readLine());

        for(int t = 1; t <= test; t++){

            int n = Integer.parseInt(br.readLine());

            int v = 0;          // 속도
            int len = 0;        // 거리
            int a = 0;          // 가속도

            for(int i = 0; i < n; i++){
                st = new StringTokenizer(br.readLine());
                int num = Integer.parseInt(st.nextToken());

                if(num == 0){
                    len += v;
                }
                else{
                    a = Integer.parseInt(st.nextToken());

                    if(num == 1){
                        v += a;
                        len += v;
                    }
                    else{
                        v -= a;
                        if(v < 0) v = 0;
                        //속도는 0보다 작아질수 없다.
                        len +=v;
                    }
                }
            }
            System.out.printf("#%d %d\n",t, len);

        }
    }
}
