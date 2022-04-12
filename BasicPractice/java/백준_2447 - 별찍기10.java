import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));     //빠른 출력을 위해
        Scanner s = new Scanner(System.in);

        int n = s.nextInt();
        char[][] arr = new char[n][n];

        //배열 초기화
        for(int i = 0; i<arr.length; i++) Arrays.fill(arr[i], ' ');
        Arrays.fill(arr[0], 0, 3, '*');
        arr[1][0] = '*'; arr[1][2] = '*';
        Arrays.fill(arr[2], 0, 3, '*');

        //로직
        int m = 3;

        while(m < n){
            int one_three = m;
            int two_three = m*2;
            for(int i = 0; i<m; i++) System.arraycopy(arr[i], 0, arr[i], one_three, m);
            for(int i = 0; i<m; i++) System.arraycopy(arr[i], 0, arr[i], two_three, m);
            for(int i = 0; i<m; i++) System.arraycopy(arr[i], 0, arr[i+one_three], 0, m);
            for(int i = 0; i<m; i++) System.arraycopy(arr[i], 0, arr[i+one_three], two_three, m);
            for(int i = 0; i<m; i++) System.arraycopy(arr[i], 0, arr[i+two_three], 0, m);
            for(int i = 0; i<m; i++) System.arraycopy(arr[i], 0, arr[i+two_three], one_three, m);
            for(int i = 0; i<m; i++) System.arraycopy(arr[i], 0, arr[i+two_three], two_three, m);
            m*=3;
        }

        //출력
        for(int i =0 ; i<arr.length; i++){
            for(int j = 0; j<arr[i].length; j++){
                bw.write(arr[i][j]);
            }
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }
}
