import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 다른 LIS알고리즘과 동일하게 쉬운 문제들은 그냥 memoization만 지속적으로 확인하며 업데이트
 */

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n + 1];
        int[] count = new int[n + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i < n + 1; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int ans = 0;
        for (int i = 1; i < n + 1; i++) {
            int max = 0;
            for (int j = i - 1; j >= 0; j--) {
                if (arr[j] > arr[i]) {
                    max = Math.max(max, count[j]);
                }
            }
            count[i] = max + 1;
            ans = Math.max(ans, count[i]);
        }

        System.out.println(ans);

    }
}