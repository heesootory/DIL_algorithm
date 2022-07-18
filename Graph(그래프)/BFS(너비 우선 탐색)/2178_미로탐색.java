import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 *  bfs 문제
 *  경로를 탐색해서 4방향으로 모두 확인하며 이동하는데, 최단경로를 말하기 때문에 먼저 도착해서 그 공간을 false로 만들어 버리면, 뒤늦게 따라오는 경로가
 *  어차피 도착을 못하게 됨.
 *  따라서 마지막에 도착지점의 수를 구하면 제일 먼저 도착한 경로에 있는 수들의 합이 출력된다.
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

public class Main {
    static int n;
    static int m;
    static int[][] map;
    static boolean[][] check_map;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};

    static void BFS(Pair s){
        Queue<Pair> q = new LinkedList();
        q.add(s);
        check_map[s.x][s.y] = false;
        
        while(!q.isEmpty()){
            Pair f = q.peek();
            q.poll();
            // 경로 정리
            for(int i = 0; i < 4; i++){
                int next_x = f.x + dx[i];
                int next_y = f.y + dy[i];

                if(next_x < 0 || next_x >= n || next_y < 0 || next_y >= m) continue;            //맵밖으로 나가는 범위 일단 제외.

                if(check_map[next_x][next_y] && map[next_x][next_y] == 1){
                    map[next_x][next_y] = map[f.x][f.y] + map[next_x][next_y];      // 경로를 가면서 경로에있는 수들을 더함.
                    Pair next_p = new Pair(next_x, next_y);
                    q.add(next_p);          //다음 경로 큐에 넣음
                    check_map[next_x][next_y] = false;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
        StringTokenizer s = new StringTokenizer(br.readLine());

        n = Integer.parseInt(s.nextToken());
        m = Integer.parseInt(s.nextToken());

        map = new int[n][m];
        check_map = new boolean[n][m];

        for(int i = 0; i<n; i++){
            String oneline = br.readLine();         //string타입으로 한줄씩 받아옴.
            for(int j = 0; j < m; j++){
                map[i][j] = oneline.charAt(j) - '0';
                if(map[i][j] == 1) check_map[i][j] = true;
            }
        }
        Pair start = new Pair(0,0);
        BFS(start);

        System.out.println(map[n-1][m-1]);
    }
}
