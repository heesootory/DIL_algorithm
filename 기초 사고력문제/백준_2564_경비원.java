import java.io.*;
import java.util.*;

/**
 *  방향 |  원점  |  시계  | 반시계  |
 *               (|나-초소|)
 *   1  |   4    |  18   |   12   |
 *   2  |   28   |   6   |   24   |
 *   3  |   17   |   5   |   25   |
 *   나 |   22
 *
 *  조건이 많은 문제도 최대한 쉽게 생각하려면 모두 같은 경우의 계산방법으로 통일시킨뒤,
 *  전체에서 빼는 방법을 생각해보자.
 */


public class Main {
    static int row;
    static int col;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        row = Integer.parseInt(st.nextToken());
        col = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int num = Integer.parseInt(st.nextToken());

        int[] len_arr = new int[num];

        for(int t = 0; t < num; t++){
            st = new StringTokenizer(br.readLine());
            int way = Integer.parseInt(st.nextToken());
            int len = Integer.parseInt(st.nextToken());
            switch(way){
                case 1: len_arr[t] = len; break;
                case 2: len_arr[t] = row*2 + col - len;break;
                case 3: len_arr[t] = (row + col) * 2 - len;break;
                case 4: len_arr[t] = row + len;break;
            }
        }

        // 나의 위치
        st = new StringTokenizer(br.readLine());
        int me_way = Integer.parseInt(st.nextToken());
        int me_len = Integer.parseInt(st.nextToken());
        int me = 0;
        switch(me_way){
            case 1: me = me_len; break;
            case 2: me = row*2 + col - me_len;break;
            case 3: me = (row + col) * 2 - me_len;break;
            case 4: me = row + me_len;break;
        }
        int sum = 0;
        for(int i= 0; i< len_arr.length; i++){
            int a = Math.abs(me - len_arr[i]);
            int b = (row + col) * 2 - a;
            sum += Math.min(a,b);
        }

        System.out.println(sum);

    }
}
