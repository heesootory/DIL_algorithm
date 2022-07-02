import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args)throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int m = s.nextInt();

        int[][] arr= new int[1000][1000];
        int k = 1;
        int i = n/2;
        int j = n/2;
        int num = 1;

        arr[i][j] = num;
        while(k <= n){
            if(k == n){
                for(int r = 0; r< k -1; r++){
                    i--;
                    num++;
                    arr[i][j] = num;
                }
            }
            else if (k % 2 != 0)
            {
                for (int r = 0; r < k; r++)
                {
                    i--;
                    num++;
                    arr[i][j] = num;
                }

                for (int r = 0; r < k; r++)
                {
                    j++;
                    num++;
                    arr[i][j] = num;
                }
            }
            else
            {
                for (int r = 0; r < k; r++)
                {
                    i++;
                    num++;
                    arr[i][j] = num;
                }

                for (int r = 0; r < k; r++)
                {
                    j--;
                    num++;
                    arr[i][j] = num;
                }
            }

            k++;
        }
        int ans_i = 0;
        int ans_j = 0;
        for(int a= 0; a < n; a++){
            for(int b = 0; b < n; b++){
                bw.write(arr[a][b] + " ");
                if(arr[a][b] == m){
                    ans_i = a;
                    ans_j = b;
                }
            }
            bw.newLine();
        }
        bw.write((ans_i+1) + " " + (ans_j+1));
        bw.flush();
    }
}