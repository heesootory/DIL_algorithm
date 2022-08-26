import java.io.*;
import java.util.*;


public class Main {
    static int[] way_arr;
    static int[] len_arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        way_arr = new int[8];
        len_arr = new int[8];
        int max_row_len = 0;
        int max_row_idx = 0;

        int max_col_len = 0;
        int max_col_idx = 0;

        for(int i = 1; i < 7; i++){
            st = new StringTokenizer(br.readLine());

            len_arr[i] = Integer.parseInt(st.nextToken());
            way_arr[i] = Integer.parseInt(st.nextToken());

            if(len_arr[i] == 1 || len_arr[i] == 2){
                if(max_row_len < way_arr[i]) {
                    max_row_len = way_arr[i];
                    max_row_idx = i;
                }
            }
            if(len_arr[i] == 3 || len_arr[i] == 4){
                if(max_col_len < way_arr[i]){
                    max_col_len = way_arr[i];
                    max_col_idx = i;
                }
            }
        }
        // 제일 긴 쪽의 변 양쪽의 변의 길이를 구하기 위해,
        // 제일 끝변과 제일 처음 변을 추가로 저장.
        way_arr[0] = way_arr[6];
        way_arr[7] = way_arr[1];

        int whole_scale = max_row_len * max_col_len;
        int small_row = Math.abs(way_arr[max_row_idx-1] - way_arr[max_row_idx+1]);
        int small_col = Math.abs(way_arr[max_col_idx-1] - way_arr[max_col_idx+1]);
        int small_scale = small_row * small_col;

        System.out.println((whole_scale - small_scale) * n);

    }
}