import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int[][] arr = new int[1100][1100];

        int n = Integer.parseInt(br.readLine());

        int num = 1;
        for(int i = 0; i< n; i++){

            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());

            // 좌표가 다르기 때문에 배열에 저장하는 순서를 달리 해야함.
            for(int b = x; b < x + w; b++){
                for(int a = y; a < y + h; a++){
                    arr[a][b] = num;
                }
            }
            num++;
        }

        int[] cnt_arr = new int[n+1];
        for(int[] i : arr){
            for(int j : i) cnt_arr[j]++;
        }

        for(int i = 1; i <cnt_arr.length; i++)
            System.out.println(cnt_arr[i]);

    }
}
