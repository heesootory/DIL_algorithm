import java.io.*;
import java.util.*;

/**
 *  전체 100*100영역을 메모리 영역으로 생각하면, 색종이 영역은 데이터가 저장된 곳이라고 생각할 수 잇다.
 *  둘레의 길이는 4방향 탐색을 했을때, 0(빈부분)의 갯수를 모두 세면 가능하다.
 *
 */


public class Main {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int[][] map;
    static int cnt = 0;
    static void check(int i, int j){
        for(int a = 0; a < 4; a++){
            if(map[i+dx[a]][j+dy[a]] == 0){
                cnt++;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        map = new int[103][103];

        int n = Integer.parseInt(st.nextToken());

        for(int i =0; i< n; i++){
            st = new StringTokenizer(br.readLine());

            int r = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());
            // 배열 색칠
            for(int a = r + 1; a < r + 11; a++){
                for(int b = l + 1; b < l +11; b++){
                    map[b][a] = 1;
                }
            }
        }

        for(int i = 1; i < 101; i++){
            //System.out.println();
            for(int j = 1 ; j < 101; j++){
                if(map[i][j] == 1) {
                    check(i, j);
                }
                //System.out.print(map[i][j]);
            }
        }
        System.out.println(cnt);



    }
}
