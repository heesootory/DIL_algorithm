import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 *  대표적인 "최장 증가 부분 수열(LIS)" 알고리즘이다.
 *  dp 는 재귀함수를 사용하는 (top-bottom) 방식을 사용하던, 반복문 방식(bottom-top)방식을 해결하던 중요한 건
 *  작은 경우에서 부터 메모이제이션으로 기록을 한 것을 이용하는게 중요하다.
 *  앞의 경우들을 어떻게 활용할지에 방점을 두자.
 *
 *  이 문제는 결국 수를 하나씩 검토하며, 앞에 나왔던 수들 중 자신 보다 작은 수열의 부분집합을 구하면 되는 것이다.
 *  앞서 나온 수열들의 부분수열의 갯수를 기록(dp[])를 확인하면서, 자신 보다 작은 수의 dp의 최댓값보다 1씩 더해 다시 저장하는 방식으로
 *  진행하면 쉽게 생가할 수 있다.
 */

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        int[] dp = new int[n];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i<n; i++) arr[i] = Integer.parseInt(st.nextToken());

        int ans = 1;
        dp[0] = 1;
        for(int i = 1; i< n; i++){
            int max = 0;
            for(int j = i-1; j >= 0; j--){          // 배열의 수를 하나씩, 그 지점을 기준으로 이전 수들중  
                if(arr[j] < arr[i]){                // 현재의 수보다 작을 때
                    max = Math.max(max, dp[j]);     // dp에 기록된 수의 최댓값을 찾고
                }
            }
            dp[i] = max+1;                          // dp의 값 중 죄댓값+1 로 최신화
            ans = Math.max(ans, dp[i]);      // memoization 을 기록하면서 최댓값 업데이트
        }
        System.out.println(ans);


    }
}