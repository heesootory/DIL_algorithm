import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        int[][] arr = new int[n][n];

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[] row_arr = new int[n];
        for(int i = 0 ; i < n; i++){
            int sum = 0;
            for(int j = 0; j < n; j++){
                sum += arr[i][j];
            }
            row_arr[i] = sum;
        }

        int[] col_arr = new int[n];
        for(int i = 0 ; i < n; i++){
            int sum = 0;
            for(int j = 0; j < n; j++){
                sum += arr[j][i];
            }
            col_arr[i] = sum;
        }

        int row_cnt = 0;
        int row_err = -1;
        int col_cnt = 0;
        int col_err = -1;
        for(int i = 0; i < n; i++) {
            if(row_arr[i] % 2 != 0) {
                row_cnt++;
                row_err = i;
            }
        }
        for(int i = 0; i < n; i++){
            if(col_arr[i] % 2 != 0) {
                col_cnt++;
                col_err = i;
            }
        }

        if(row_cnt == 0 && col_cnt == 0) System.out.println("OK");
        else if(row_cnt == 1 && col_cnt == 1) System.out.printf("Change bit (%d,%d)", row_err+1, col_err+1);
        else System.out.println("Corrupt");

    }
}