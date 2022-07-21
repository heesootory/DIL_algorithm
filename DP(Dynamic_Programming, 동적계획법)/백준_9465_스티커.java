import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * - 스스로 못 푼 문제 -
 * dp를 자꾸만 기록하며 앞으로 나아가며, 이전에 기록했던 수들을 사용한다....라고만 생각하는데,
 * 생각의 전환이 필요한 것같다. 이 문제에서 생각하지 못했던 점.
 * 1. 2번째 항부터 규칙이 적용될 수 있다는 점.
 * 2. 대각선 방향의 두칸까지 이동이 가능하다는 생각을 했지만, 현재위치에서 앞선 두값중 최댓값(합들을 기록한 배열에서)을 가져와서 더해
 * 다시 기록한다는 생각을 하지 못했다.
 *
 * - 개선할 점 -
 * 1. 문제를 보고, 조건안에서 선택할 수 있는 경우의 수를 먼저 찾자
 * - 동적계획법 , 말 그대로 계획대로 이동하면서 같은 규칙을 가져가는 것이다.
 * 2. 현재 배열의 위치에서 다음 어디로 갈지 계획을 세우는 것 != 앞선수들이 기록이 되어온 것을 가지고 현재위치의 값을 정하자
 * - 이둘은 완전 다른 결과를 낳게 되고, 후자를 잘 생각하지 못한다.
 */

public class Main {
    static int[][] arr;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int t = Integer.parseInt(st.nextToken());

        while (t-- > 0) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());

            arr = new int[2][n + 1];
            dp = new int[2][n + 1];

            for (int i = 0; i < 2; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 1; j < n + 1; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            dp[0][1] = arr[0][1];
            dp[1][1] = arr[1][1];

            for (int i = 2; i < n + 1; i++) {
                dp[0][i] = Math.max(dp[1][i - 1], dp[1][i - 2]) + arr[0][i];
                dp[1][i] = Math.max(dp[0][i - 1], dp[0][i - 2]) + arr[1][i];
            }

            System.out.println(Math.max(dp[0][n], dp[1][n]));

        }

    }
}