import java.io.*;
import java.util.*;

public class Main {
    static int[] dx = {-1, -1, -1, 0, 1, 1 ,1 ,0};
    static int[] dy = {-1, 0, 1, 1, 1, 0, -1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int test = Integer.parseInt(br.readLine());

        for(int t = 1; t <= test; t++) {
            int n = Integer.parseInt(br.readLine());

            char[][] arr = new char[n][n];

            for(int i =0 ; i < n; i++){
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j < n; j++){
                    arr[i][j] = st.nextToken().charAt(0);
                }
            }

            int max_cnt = 0;
            for(int i = 0; i < n ; i++){
                for(int j = 0; j < n; j++){
                    int cnt = 0;
                    if(arr[i][j] == 'W'){
                        for(int k = 0; k < 8; k++){
                            int next_x = i + dx[k];
                            int next_y = j + dy[k];

                            if(next_x < 0 || next_x >= n|| next_y < 0 || next_y >= n) continue;

                            if(arr[next_x][next_y] == 'W') cnt++;
                        }
                        if(cnt == 0) cnt++;
                    }
                    if(cnt > max_cnt) max_cnt = cnt;
                }
            }

            System.out.printf("#%d %d\n", t, max_cnt);

        }
    }
}
