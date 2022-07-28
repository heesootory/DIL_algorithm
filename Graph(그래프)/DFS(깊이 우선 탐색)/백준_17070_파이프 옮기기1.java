import java.io.*;
import java.util.*;

class pipe{
    int way;
    int x;
    int y;
    public pipe(int way, int x, int y){
        this.way = way;
        this.x = x;
        this.y = y;
    }
}

public class Main{
    static final int row = 0;
    static final int column = 1;
    static final int diagonal = 2;
    static int[][] arr;
    static int n;
    static int cnt = 0;
    static void DFS(pipe p){
        if(p.x == n-1 && p.y == n-1){
            cnt++; return;
        }

        switch(p.way){
            case row:
                if(p.y < n-1 && arr[p.x][p.y+1] == 0 ) DFS(new pipe(row, p.x, p.y+1));
                break;
            case column:
                if(p.x < n-1 && arr[p.x+1][p.y] == 0) DFS(new pipe(column, p.x+1, p.y));
                break;
            case diagonal:
                if(p.y < n-1 && arr[p.x][p.y+1] == 0 ) DFS(new pipe(row, p.x, p.y+1));
                if(p.x < n-1 && arr[p.x+1][p.y] == 0) DFS(new pipe(column, p.x+1, p.y));
                break;
        }
        // 대각선은 문제에서 모든 방향을 고려!!!
        if(p.x < n-1 && p.y < n-1 && arr[p.x+1][p.y+1] == 0 && arr[p.x+1][p.y] == 0 && arr[p.x][p.y+1] == 0)
            DFS(new pipe(diagonal, p.x+1, p.y+1));



    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());

        arr = new int[n][n];
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        DFS(new pipe(row, 0, 1));
        System.out.println(cnt);
    }
}