import java.io.*;
import java.util.*;

class Pair{
    int x;
    int y;
    Pair(int x, int y){
        this.x = x;
        this.y = y;
    }
}

public class test {
    static int[][] arr;
    static int size;
    static int[] dx = {-2, -2, -1, 1, 2, 2, 1, -1};
    static int[] dy = {-1, 1, 2, 2, 1, -1, -2, -2};
    static boolean[][] visited;

    static int bfs(Pair p1, Pair p2){
        Queue<Pair> queue = new LinkedList<>();
        queue.add(p1);
        visited[p1.x][p1.y] = true;
        int cnt = 0;

        // 출발지와 목적지가 같은경우 -> 0 리턴
        if((p1.x == p2.x) && (p1.y == p2.y)) return cnt;

        while(!queue.isEmpty()){
            cnt++;

            //한 턴씩 구현
            int len = queue.size();
            for(int i = 0; i < len; i++){
                Pair now = queue.poll();

                for(int d = 0; d < dx.length; d++){
                    int next_x = now.x + dx[d];
                    int next_y = now.y + dy[d];

                    // 맵 밖으로 나가는 경우 제외
                    if(next_x < 0 || next_y < 0 || next_x >= size || next_y >= size) continue;

                    //방문했던 곳 제외
                    if(visited[next_x][next_y]) continue;

                    // 도착지에 도착한 경우 리턴
                    if((next_x == p2.x) && (next_y == p2.y)) return cnt;

                    // 큐에 재진입 , 방문처리
                    queue.add(new Pair(next_x, next_y));
                    visited[next_x][next_y] = true;
                }
            }
        }

        return cnt;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int test = Integer.parseInt(br.readLine());

        for(int t = 1; t <= test; t++){

            size = Integer.parseInt(br.readLine());
            arr = new int[size][size];
            visited = new boolean[size][size];

            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());

            Pair p1 = new Pair(x1, y1);

            st = new StringTokenizer(br.readLine());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            Pair p2 = new Pair(x2, y2);

            System.out.println(bfs(p1, p2));

        }

    }
}
