import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.*;

/**
 *  LIS 알고리즘
 *  dp 중 쉬운 부분에 속함.
 *  memoization 을 해당수열과 같은 크기로 동시에 기록해 나가면서, 원소마다 memoization을 회고해서 조건에 맞는 값으로 갱신.
 *
 */

public class Main{
    static int n;
    static int[] arr;
    static int[] max_sum;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        arr = new int[n+1];
        max_sum = new int[n+1];

        st = new StringTokenizer(br.readLine());
        for(int i = 1; i<= n; i++) arr[i] = Integer.parseInt(st.nextToken());

        int ans = 0;
        for(int i = 1; i < n+1; i++){
            int elem = arr[i];
            int max = 0;
            //-------------------------------------- LIS 알고리즘의 가장 중요한 부분
            for(int j = i-1; j>= 0; j--){               // memoization을 뒤로 다시 탐색하며
                if(arr[j] < elem){                      // 조건에 맞는 (증가하는이므로, 현재 원소보다 작은 원소중)
                    max = Math.max(max, max_sum[j]);     // memoization이 가장 큰 수를 뽑아냄
                }
            }
            //--------------------------------------
            max_sum[i] = max + elem;                    // 최댓값으로 갱신
            ans = Math.max(ans, max_sum[i]);
        }
        System.out.println(ans);
    }
}