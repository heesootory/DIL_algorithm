import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 *  dfs 함수안에서 출력하면서 출력 순서를 구하는게 아니라, 방문 배열을 따로 만들고 출력순서를 기입해서 그 배열을 그대로 출력하는 것.
 */

public class Solution {
    static int len = 100001;
    static ArrayList<Integer>[] edge = new ArrayList[len];
    static boolean[] check = new boolean[len];
    static int[] visited;       // 방문 순서를 기록할 배열
    static int cnt = 1;

    static void DFS(int s){
        if(check[s]) return;

        visited[s-1] = cnt++;
        check[s] = true;
        for(int i : edge[s]) DFS(i);
    }

    public static void main(String[] args) throws IOException {
        for(int i = 0; i< len; i++) edge[i] = new ArrayList();
        Scanner s = new Scanner(System.in);

        int n = s.nextInt();
        int m = s.nextInt();
        int r = s.nextInt();
        visited = new int[n];

        for(int i = 0; i < m; i++){
            int a = s.nextInt();
            int b = s.nextInt();

            edge[a].add(b);
            edge[b].add(a);
        }

        for(int i = 0; i < n; i++) Collections.sort(edge[i]);

        DFS(r);

        for(int i : visited) System.out.println(i);

    }
}
