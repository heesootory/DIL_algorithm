import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.*;

/**
 *  변화하고 있는 것에 초점을 맞추자. ->  자꾸 뭉뚱그려서 보는게 아니라!!
 *  문제에서 제시된 n 줄이라는 것은 dp 적인 관점으로 보았을 때, 계속해서 n줄이 추가되고
 *  이전의 경우의 수들이 n라인의 경우의 수에 영향을 미치게 되는것을 말한다.
 *
 *  n라인에서 각각 칸마다의 경우의 수를 본다면 -> 없을때, 첫번째칸, 두번째칸 -> dp[n][0], dp[n][1], dp[n][2]
 *  이렇게 3가지 경우의 수밖에 없으므로, 이 각각의 경우의 수가 이전의 경우에 따라 수가 어떻게 변화하는지 추세를 보는 것이 핵심이다.
 *  여기서 dp배열에 대한 n의 식만 나오면 문제는 쉽게 풀린다.
 */


public class Main{

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(br.readLine());


        long[][] dp = new long[n][3];
        dp[0][0] = dp[0][1] = dp[0][2] = 1;

        // 나중에 n의 값이 커지면 long 타입으로 커버가 안되므로, 오버플로를 방지하기 위해 나머지 연산을 계속 시행시킨다.
        // 나머지 계산도 분배법칙이 적용됨!!!
        for(int i = 1; i < n; i++){
            dp[i][0] = (dp[i-1][0] + dp[i-1][1] + dp[i-1][2]) % 9901;
            dp[i][1] = (dp[i-1][0] + dp[i-1][2]) % 9901;
            dp[i][2] = (dp[i-1][0] + dp[i-1][1]) % 9901;        // 각각의 나머지를 더해도 결국 다 더한것의 나머지와 동일
        }

        long ans = (dp[n-1][0] + dp[n-1][1] + dp[n-1][2]) % 9901;       // 각각을 더해서 9901이상이 나오는 경우가 있으므로, 다시한번 나머지를 구한다.
        System.out.println(ans);

    }
}