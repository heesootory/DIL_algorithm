import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[][] arr = new int[2][6];

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());       // 성별
            int y = Integer.parseInt(st.nextToken());       // 학년
            arr[x][y-1]++;
        }

        int cnt = 0;
        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr[i].length; j++){
                cnt += (arr[i][j] / k);
                if(arr[i][j] % k != 0) cnt++;
            }
        }

        System.out.println(cnt);


    }
}