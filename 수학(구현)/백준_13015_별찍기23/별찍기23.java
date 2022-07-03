import java.io.*;
import java.util.*;

public class Main{
    public static char[][] arr = new char[200][400];

    public static void set(int n, int r, int idx){
        int row = 2*n-1;
        int col = 4*n-3;

        for(int i = 0; i< col - idx + 1; i++) arr[r][i] = ' ';
a
        if(r == 0 || r == row -1){
            for(int i = 0; i< n; i++) arr[r][i] = '*';
            for(int i = col - n; i< col; i++) arr[r][i] = '*';
        }
        else{
            arr[r][idx] = '*';
            arr[r][idx + n - 1] = '*';
            arr[r][col - idx - 1] = '*';
            arr[r][col - idx - n] = '*';
        }
        for(int i = 0; i< col - idx + 1; i++) System.out.print(arr[r][i]);

    }

    public static void main(String[] args)throws IOException {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int idx = 0;
        for(int i = 0; i < 2*n-1; i++){
            set(n,i, idx);
            if(i < n-1) idx++;
            else idx--;
            System.out.println();
        }
    }
}