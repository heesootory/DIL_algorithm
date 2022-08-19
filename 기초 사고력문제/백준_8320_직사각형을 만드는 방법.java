import java.io.*;
import java.util.*;

public class Main {
    static int divisor(int n){      // 약수의 쌍의 갯수를 구하는 메서드
        int cnt = 0;
        for(int i = 2; i * i <= n; i++){
            if(n % i == 0) cnt++;
        }
        return cnt;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n+1];
        arr[1] = 1;
        for(int i = 2; i < n+1; i++){
            arr[i] = arr[i-1] + 1;      // 갯수가 증가된 그냥 긴 직사각형이 항상 하나 추가되고
            arr[i] += divisor(i);       // 약수의 쌍만큼 N * N 배열이 추가된다.
        }

        System.out.println(arr[n]);

    }
}
