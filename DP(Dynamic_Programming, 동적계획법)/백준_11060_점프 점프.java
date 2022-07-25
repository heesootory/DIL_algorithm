import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 한 칸짜리만 있어도 가능한 테케들을 잘 생각하자.
 *
 * 재귀 (top - bottom) 으로 푼 dp문제
 *
 * 동적계획법을 생각하면 흔히 떠오르는 그래프 모양을 그냥 가로로 눞힌 셈이다. 똑같이 memoization을 이용해서 최솟값을 저장해
 * 나가고,
 * 최솟값보다 큰 경우가 들어오는 경우는 return 처리.
 *
 */

public class Main {
    static int[] arr;
    static int[] count;
    static int n;

    static int dp(int a, int cnt) {
        if (a > n - 1)
            return cnt - 1;

        if (cnt + 1 < count[a] || count[a] == 0) {
            count[a] = cnt + 1;
            int range = arr[a];

            for (int i = a + 1; i < a + 1 + range; i++) {
                dp(i, count[a]);
            }
        }
        return count[a] - 1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        count = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++)
            arr[i] = Integer.parseInt(st.nextToken());
        dp(0, -1);

        if (n == 1)
            System.out.println(0);
        else if (count[n - 1] != 0)
            System.out.println(count[n - 1]);
        else
            System.out.println(-1);

    }
}