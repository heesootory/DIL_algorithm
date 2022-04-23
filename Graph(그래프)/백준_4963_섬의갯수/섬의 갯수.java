import java.io.*;
import java.util.*;

public class Main {
    static boolean[][] arr = new boolean[52][52]; // 초기값 true, false
    static void DFS(int i, int j) {
        if (arr[i][j] == false) return;

        arr[i][j] = false;
        DFS(i + 1, j);
        DFS(i + 1, j - 1);
        DFS(i + 1, j + 1);
        DFS(i, j - 1);
        DFS(i, j + 1);
        DFS(i - 1, j);
        DFS(i - 1, j - 1);
        DFS(i - 1, j + 1);
    }
    public static void main(String[] args) {
        int w,h,k;
        Scanner s = new Scanner(System.in);
        while(true){
            w = s.nextInt();
            h = s.nextInt();
            if(w == 0 && h == 0) break;
            int count = 0;
            for(int i = 1; i<=h; i++){
                for(int j = 1; j<=w; j++){
                    k = s.nextInt();
                    if(k == 1) arr[i][j] = true;
                }
            }
            for(int i = 1; i<=h ; i++){
                for(int j = 1; j<=w; j++){
                    if(arr[i][j]){
                        count++;
                        DFS(i, j);
                    }
                }
            }
            System.out.println(count);
        }

    }
}