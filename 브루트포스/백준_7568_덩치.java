import java.io.*;
import java.util.*;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        int[][] arr = new int[2][n];

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            arr[0][i] = Integer.parseInt(st.nextToken());       // 무게
            arr[1][i] = Integer.parseInt(st.nextToken());       // 키
        }

        for(int i = 0; i < n; i++){
            int idx = 1;
            for(int j = 0; j < n; j++){     // 몸무게와 키가 둘다 자신보다 큰놈만 찾자!
                if(i == j) continue;
                // 몸무게와 키가 둘다 자신보다 클 때만 idx증가.
                if(arr[0][i] < arr[0][j] && arr[1][i] < arr[1][j]) idx++;
            }
            System.out.print(idx + " ");
        }

    }
}