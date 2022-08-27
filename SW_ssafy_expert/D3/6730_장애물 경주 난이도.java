import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int test = Integer.parseInt(br.readLine());

        for(int t = 1; t <= test; t++){
            int n = Integer.parseInt(br.readLine());

            int[] arr = new int[n];
            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < n; i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }
            int up = 0;
            int down = 0;

            for(int i = 0; i < n; i++){
                // 올라가는 계단만 계산
                if((i != n-1) && (arr[i] < arr[i+1])){     
                    int u = arr[i+1] - arr[i];
                    if(u > up) up = u;
                }
                // 내려가는 계단만 계산
                if((i != 0) && (arr[i-1] > arr[i])){
                    int d = arr[i-1] - arr[i];
                    if(d > down) down = d;
                }
            }

            System.out.printf("#%d %d %d\n",t, up, down);

        }
    }
}