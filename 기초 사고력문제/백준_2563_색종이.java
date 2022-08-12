import java.io.*;
import java.util.*;

/**
 *  전체 영역 - 메모리
 *  색종이 영역 - 데이터 영역
 * 
 */

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());

        int[] arr_x = new int[n];
        int[] arr_y = new int[n];

        int max_x = Integer.MIN_VALUE;
        int max_y = Integer.MIN_VALUE;

        for(int i =0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            arr_x[i] = Integer.parseInt(st.nextToken());
            arr_y[i] = Integer.parseInt(st.nextToken());

            if(arr_x[i] > max_x) max_x = arr_x[i];
            if(arr_y[i] > max_y) max_y = arr_y[i];
        }

        int[][] map = new int[max_y+11][max_x+11];
        int cnt = 0;

        for(int k = 0; k < n; k++){
            for(int i = 0; i< max_y+11; i++){
                for(int j = 0; j< max_x+11; j++){
                    if((arr_y[k] <= i && i < arr_y[k] + 10)
                            && (arr_x[k] <= j && j < arr_x[k] + 10)){
                        map[i][j] = 1;
                    }
                }
            }
        }

        for(int i = 0; i< max_y + 11; i++){
            for(int j = 0; j < max_x + 11; j++){
                if(map[i][j] == 1) cnt++;
            }
        }

        System.out.println(cnt);


    }
}
