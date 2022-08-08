public class 백준_2792_보석상자 {
    
}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.*;

/**
 * 이분탐색
 * 이분탐색을 하기 위해서 먼저 오름차순이 필요하다
 * 오름차순이 숨어있기 때문에, 먼저 최솟값 최댓값이 될 수 있는 범위부터 찾아야 하는게 1번 할 일이다.
 * 그 후 mid를 구해보면서 어떤경우에 true인지 어떤경우엔 false인지 판단해보자.
 * 이분적으로 true, false의 범위가 나온다면 그게 기준이된다.
 * 그럼 문제는 다풀었다!
 */


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] arr = new int[m];

        for(int i = 0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int left = 1;
        int right = arr[arr.length-1];

        while(left <= right){
            int mid = (left + right) / 2;

            int cnt = 0;

            for(int i : arr){
                cnt += (i % mid == 0) ? i/mid : (i/mid+1);
            }

            if(cnt > n) left = mid + 1;
            else right = mid - 1;

        }
        System.out.println(left);


    }
}

