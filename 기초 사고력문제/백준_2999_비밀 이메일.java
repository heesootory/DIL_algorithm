import java.io.*;
import java.util.*;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();

        int len = str.length();
        int R = 0;
        int C = 0;
        for(int i = 1; i <= len; i++){
            if(len % i == 0){
                int j = len / i;
                if(i >= j){
                    R = j;
                    C = i;
                    break;
                }
            }
        }

        char[][] arr = new char[R][C];
        int k = 0;
        for(int i = 0; i < C; i++){
            for(int j = 0; j < R; j++){
                arr[j][i] = str.charAt(k++);
            }
        }

        for(int i = 0 ; i < R; i++){
            for(int j = 0; j < C; j++){
                System.out.print(arr[i][j]);
            }
        }

    }
}
