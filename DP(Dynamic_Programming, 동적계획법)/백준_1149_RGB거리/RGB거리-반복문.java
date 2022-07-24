import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


/**
 *  dp - for문(down -top)
 *  1. 쉬운 문제는 반복문을 이용해서 훨씬 간편하게 접근할 수 있다.
 *  2. 이전의 선택이 현재의 선택에 어떤 영향을 미치는지 항상 생각!!!
 *
 *  귀납법 식 : min_sum_cost[n][0] = min(min_sum_cost[n-1][1], min_sum_cost[n-1][2]) + cost[n][0]
 *
 *  🐶 n항에 대한 귀납법을 어떻게든 쓰려고 노력하자 🐶
 */

public class Main{
    static final int R = 0;
    static final int G = 1;
    static final int B = 2;
    static int[][] min_cost;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        min_cost = new int[n+1][3];
        for(int i = 1; i <= n; i++){
            st = new StringTokenizer(br.readLine());
            int red = Integer.parseInt(st.nextToken());
            int green = Integer.parseInt(st.nextToken());
            int blue = Integer.parseInt(st.nextToken());

            min_cost[i][R] = Math.min(min_cost[i-1][G], min_cost[i-1][B]) + red;
            min_cost[i][G] = Math.min(min_cost[i-1][R], min_cost[i-1][B]) + green;
            min_cost[i][B] = Math.min(min_cost[i-1][R], min_cost[i-1][G]) + blue;
        }

        Arrays.sort(min_cost[n]);
        System.out.println(min_cost[n][0]);

    }
}