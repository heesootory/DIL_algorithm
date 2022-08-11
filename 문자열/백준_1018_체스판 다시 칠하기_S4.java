import java.io.*;
import java.util.*;

/**
 * 
 *  문자열의 기준을 만들어 놓고 풀면 조금 직관적으로 접근 가능.
 */



public class Main {
    static int min = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        char[][] arr = new char[n][m];

        for(int i = 0; i < n; i++){
            String str = br.readLine();
            for(int j = 0; j < m; j++){
                arr[i][j] = str.charAt(j);
            }
        }

        char[] norm1 = new char[m];
        for(int i = 0; i < norm1.length; i++){
            norm1[i] = (i % 2 == 0) ? 'W' : 'B';
        }

        char[] norm2 = new char[m];
        for(int i =0; i< norm2.length; i++){
            norm2[i] = (i % 2 == 0) ? 'B' : 'W';
        }

        for(int a = 0; a <= n - 8; a++){
            for(int b = 0; b <= m - 8; b++){

                int diff_cnt1 = 0;
                for(int i = a; i< a + 8; i++){
                    for(int j = b; j < b + 8; j++){
                        if(i % 2 == 0) {
                            if (arr[i][j] != norm1[j]) diff_cnt1++;
                        }else {
                            if (arr[i][j] != norm2[j]) diff_cnt1++;
                        }
                    }
                }


                int diff_cnt2 = 0;
                for(int i = a; i< a + 8; i++) {
                    for (int j = b; j < b + 8; j++) {
                        if (i % 2 == 0) {
                            if (arr[i][j] != norm2[j]) diff_cnt2++;
                        } else {
                            if (arr[i][j] != norm1[j]) diff_cnt2++;
                        }
                    }
                }

                min = Math.min(min, Math.min(diff_cnt1, diff_cnt2));

            }
        }
        System.out.println(min);

    }
}