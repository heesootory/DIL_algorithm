import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


/**
 *  dp - 재귀(top - down)
 *  1. memoization을 사용해서, 단순히 기록이 중요한게 아니고, 기록을 통해 어떤 경우는 깊은 탐색이 필요없게 만드는 데서 의의가 있다.
 *  2. 경우에 따라 재귀를 나눠도 시간복잡도는 비슷함으로, 한꺼번에 모든 경우의 수를 다 확인하려고 안해도된다.
 *  3. base check에 해당하는 0라인 숫자는 memoization에 처음부터 기록해두고, 대부분의 계산은 memoization에 의해 되었다는 것을 잊지말자.
 * 
 *  귀납법 식 : min_sum_cost[n][0] = min(min_sum_cost[n-1][1], min_sum_cost[n-1][2]) + cost[n][0]
 *  
 *  🐶 n항에 대한 귀납법을 어떻게든 쓰려고 노력하자 🐶
 */

public class Main{
    static final int red = 0;
    static final int green = 1;
    static final int blue = 2;

    static int n;
    static int[][] cost;
    static int[][] min_sumcost;     // memoization

    static int dp(int n, int color){        // 대부분의 값이 memoization에 의해 계산.

        if(min_sumcost[n][color] == 0){     //1. base check -  0이 아닐 경우 base이고 0라인은 cost를 넣어주고 시작했다.
            if(color == red) {
                min_sumcost[n][color] = Math.min(dp(n-1,green), dp(n-1, blue)) + cost[n][color];
            }
            else if(color == green){
                min_sumcost[n][color] = Math.min(dp(n-1,red), dp(n-1, blue)) + cost[n][color];
            }
            else{
                min_sumcost[n][color] = Math.min(dp(n-1,red), dp(n-1, green)) + cost[n][color];
            }
        }
        return min_sumcost[n][color];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        cost = new int[n][3];
        min_sumcost = new int[n][3];

        for(int i  =0; i< n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j< 3; j++){
                cost[i][j] = Integer.parseInt(st.nextToken());
                if(i == 0) min_sumcost[i][j] = cost[i][j];      // base check때 기본 수가 들어가야, 그 수 그대로 return
            }
        }

        for(int i =0; i < 3; i++) dp(n-1, i);
        Arrays.sort(min_sumcost[n-1]);
        System.out.println(min_sumcost[n-1][0]);



    }
}