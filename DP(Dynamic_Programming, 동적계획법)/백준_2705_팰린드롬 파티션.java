import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 일반적인 동적 계획법 처럼 앞의 나온 배열들이 뒤에 어떤 영향을 미치는지 파악하는 문제.
 * 특히, 그냥 팰린드롬(회문)이 아니라 재귀적인 팰린드롬이라는 점에서 주의.
 * 예를들어, 7에 해당하는 재귀적인 팰리드롬 파티션 중에서는 2+1+2+1+2 와 같은 것을 될수 없다(1을 중심으로 2+1과1+2는 같지 않다 -> 재귀적이지 않다.)
 *  
 */

public class Solution {


    public static void main(String[] args) throws IOException {
        Scanner s = new Scanner(System.in);

        int t = s.nextInt();
        int[] arr = new int[1001];
        arr[1] = 1;

        for(int i = 2; i<arr.length; i++){
            int sum = 0;
            for(int j = 1; j <= i/2; j++) sum += arr[j];
            arr[i] = ++sum;
        }

        while(t-- > 0){
            int n = s.nextInt();
            System.out.println(arr[n]);
        }


    }
}
