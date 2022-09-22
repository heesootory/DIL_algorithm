import java.io.*;
import java.util.*;


public class Main {
    static int N;
    static int cnt;
    static int[] visited;
    static boolean check(int row, int col){
        for(int i = 0; i < row; i++){
            if(Math.abs(row - i) == Math.abs(col - visited[i])) return false;
            if(visited[i] == col) return false;
        }
        return true;
    }

    static void dfs(int row){
        if(row == N){
            cnt++;
            return;
        }

        for(int col = 0; col < N; col++){
            if(!check(row, col)) continue;
            visited[row] = col;
            dfs(row + 1);
            visited[row] = -1;

        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        visited = new int[N];
        Arrays.fill(visited, -1);

        dfs(0);

        System.out.println(cnt);




    }
}

