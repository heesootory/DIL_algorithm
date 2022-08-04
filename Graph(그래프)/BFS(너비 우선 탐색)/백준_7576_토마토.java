import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 *  bfs 문제
 *  그래프마다 계층별로 검사하여, 그 계층 step을 세는 최단경로를 구하는 방식과 마찮가지인 문제.
 *
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
    static int m;
    static int[][] box;
    static ArrayList<Pair> tomato = new ArrayList();        //익은 토마토들 저장하는 동적배열
    static int day = 0;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};

    static void BFS(){
        Queue<Pair> q = new LinkedList();
        for(int i = 0; i< tomato.size(); i++) q.add(tomato.get(i));     // 처음 확인했을 때 익은 토마토 큐에 삽입.

        while (!q.isEmpty()) {
            int len = q.size();                     // !! 사이즈는 항상 다음 계층 검사시, 처음에 한번만 검사해야함!!! -> 반복문에서 사이즈를 검사하면 q에 추가되는 족족 사이즈가 증가함..
            for (int k = 0; k < len; k++) {               // 그래프의 계층 별로 동시에 익고, 날짜가 올라가므로 -> 계층별 확인
                Pair f = q.peek(); q.poll();
                for (int j = 0; j < 4; j++) {
                    int next_x = f.x + dx[j];
                    int next_y = f.y + dy[j];

                    if (next_x < 0 || next_x >= n || next_y < 0 || next_y >= m) continue;            //상자 밖 제외

                    if (box[next_x][next_y] == 0) {
                        q.add(new Pair(next_x, next_y));
                        box[next_x][next_y] = 1;
                    }
                }
            }
            day++;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        m = Integer.parseInt(st.nextToken());       //가로
        n = Integer.parseInt(st.nextToken());       //세로

        box = new int[n][m];

        for(int i =0 ; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j =0 ; j < m; j++){
                box[i][j] = Integer.parseInt(st.nextToken());
                if(box[i][j] == 1){
                    Pair p = new Pair(i,j);
                    tomato.add(p);
                }
            }
        }

        BFS();

        boolean impossible = false;

        for(int[] i : box){
            for(int j : i){
                if(j == 0){
                    impossible = true; break;
                }
            }
        }

        System.out.println((impossible) ? -1 : day-1);

    }
}
