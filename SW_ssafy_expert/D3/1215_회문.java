import java.io.*;
import java.util.*;

public class Main {
    static int cnt;
    static void check(char[][] arr, int n){
        for(int i = 0; i < 8; i++){
            for(int j = 0; j <= 8 - n; j++){
                boolean pelindrome = true;
                for(int a = j, b = j + n - 1; a <= b; a++, b--){
                    if(arr[i][a] != arr[i][b]) {
                        pelindrome = false; break;
                    }
                }
                if(pelindrome) cnt++;
            }
        }
    }
    static char[][] pivot_90degree(char[][] arr){
        int size = 8;
        char[][] arr2 = new char[size][size];
        for(int i =0 ; i < size; i++){
            for(int j = 0 ; j < size; j++){
                arr2[i][j] = arr[(size - 1) - j][i];
            }
        }
        return arr2;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int test = 10;

        for(int t = 1; t <= test; t++) {
            cnt = 0;
            int n = Integer.parseInt(br.readLine());
            int size = 8;
            char[][] arr = new char[size][size];

            for(int i = 0 ; i < size ; i++){
                String str = br.readLine();
                for(int j = 0; j < size; j++){
                    arr[i][j] = str.charAt(j);
                }
            }

            check(arr, n);      // 정상배열 회문 검사
            char[][] pivot_arr = pivot_90degree(arr);   //배열 90도 회전
            check(pivot_arr, n);            // 90도 회전 배열 회문 검사

            System.out.printf("#%d %d\n", t, cnt);
        }
    }
}
