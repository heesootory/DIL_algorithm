import java.io.*;
import java.util.*;

public class Main {
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int test = Integer.parseInt(br.readLine());

        for(int t = 1; t <= test; t++) {
            int n = Integer.parseInt(br.readLine());

            int[][] arr = new int[n][n];
            int num = 1;
            int x = 0, y = -1;
            for(int i = 0; i < n; i++) arr[x][++y] = num++;
            n--;        // 4 33 22 1 -> 첫번째로 n 줄여주기
            int k = 0;
            while(n > 0){
                for(int i = 0; i < 2; i++){
                    for(int j = 0; j < n; j++){
                        x = x + dx[k];
                        y = y + dy[k];
                        //System.out.println(x + " " + y);
                        arr[x][y] = num++;
                    }
                    //방향 바꾸기
                    k++;
                    k %= 4;
                }
                n--;
            }
            System.out.printf("#%d\n", t);
            for(int[] i : arr){
                for(int j : i) System.out.print(j + " ");
                System.out.println();
            }

        }
    }
}
