import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 *  BFS 를 매개변수를 이용해서 적록색맹과 아닌사람의 값을 다르게 리턴해서 나타내자.
 *  BFS 함수 안에서 적록색맹과 정상인의 판을 다르게 해서, 탐색만 해준다.
 *  방문기록을 통해 각각 갯수만 세면 끝!
 */

class Pair{
    int x = 0;
    int y = 0;
    public Pair(int x, int y){
        this.x = x;
        this.y = y;
    }
}

public class Solution {
    static int n;
    static char[][] arr;
    static char[][] blind_arr;      // 적록 색약의 배열을 따로 만듬
    static boolean[][] check;       // 방문한지 체크
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static void BFS(Pair p, boolean color_blind, char c){        //매개변수 :  탐색을 시작할 좌표, 적록 색약 유무, 글자
        Queue<Pair> q = new LinkedList();
        char[][] map = (color_blind) ? blind_arr : arr;     // 구별해서 판을 정하고 탐색.
        q.add(p);
        check[p.x][p.y] = true;

        while(!q.isEmpty()){
            Pair f = q.peek(); q.poll();

            for(int i =0; i < 4 ; i++){
                int next_x = f.x + dx[i];
                int next_y = f.y + dy[i];

                if(next_x < 0 || next_y < 0 || next_x >= n || next_y >=n) continue;

                if(map[next_x][next_y] == c && !check[next_x][next_y]){
                    q.add(new Pair(next_x, next_y));
                    check[next_x][next_y] = true;
                }
            }
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());

        arr = new char[n][n];
        blind_arr = new char[n][n];
        check = new boolean[n][n];

        for(int i = 0; i<n; i++){
            String str = br.readLine();
            for(int j =0 ; j< n; j++){
                char color = str.charAt(j);
                arr[i][j] = color;          // 정상인 배열
                blind_arr[i][j] = (color == 'G') ? 'R' : color;     // 적록 색맹은 애초의 배열을 다르게 받기.
            }
        }

        // 정상인
        int cnt = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j< n; j++){
                if(!check[i][j]) {
                    cnt++;
                    BFS(new Pair(i,j), false, arr[i][j]);
                }
            }
        }
        for(int i = 0; i< check.length; i++) Arrays.fill(check[i], false);      // 적록색약도 검사를 위해 체크판 초기화

        // 적록 색약
        int blind_cnt = 0;
        for(int i = 0; i< n; i++){
            for(int j = 0; j < n; j++){
                if(!check[i][j]){
                    blind_cnt++;
                    BFS(new Pair(i,j), true, blind_arr[i][j]);
                }
            }
        }
        System.out.println(cnt + " " + blind_cnt);
    }
}
