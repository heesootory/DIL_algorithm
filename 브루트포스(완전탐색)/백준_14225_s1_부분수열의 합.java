import java.io.*;
import java.util.*;


public class Main {
    static int N;
    static int[] arr;
    static int max;
    static boolean[] visited;
    static boolean[] sum_arr;
    static void dfs(int idx, int sum){
        if(idx == N){
            sum_arr[sum] = true;
            return;
        }

        dfs(idx + 1, sum + arr[idx]);
        dfs(idx + 1, sum);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        visited = new boolean[N];
        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            max += arr[i];
        }
        sum_arr = new boolean[max+1];

        dfs(0,0);

        int ans = -1;
        for(int i = 1; i <= max; i++){
            if(!sum_arr[i]) {
                ans = i; break;
            }
        }
        System.out.println((ans == -1) ? max+1 : ans);
    }
}