import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;



public class test {

    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for(int t = 1; t <= 10; t++){
            int[][] map = new int[100][100];

            int no = Integer.parseInt(br.readLine());

            for(int i = 0; i< 100; i++){
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j < 100; j++){
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int cnt = 0;
            for(int i = 0; i< 100; i++){
                boolean n_check = false;            // 줄마다 체크 갱신.
                for(int j = 0; j < 100; j++){
                    if(map[j][i] == 1) n_check = true;
                    if(n_check && map[j][i] == 2) {
                        n_check = false;
                        cnt++;
                    }
                }
            }
            System.out.println("#" + t + " " + cnt);
        }

    }
}
