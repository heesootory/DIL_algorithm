import java.io.*;
import java.util.*;


public class Main {
    static int N, K;
    static int[] arr;
    static int cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arr = new int[N];
        for(int i = 0; i < N; i++) arr[i] = Integer.parseInt(br.readLine());

        for(int i = N - 1; i >= 0; i--) {
            if(arr[i] <= K){
                int part_cnt = (K / arr[i]);
                cnt += part_cnt;
                K -= (arr[i]* part_cnt);
            }
        }
        System.out.println(cnt);
    }
}

