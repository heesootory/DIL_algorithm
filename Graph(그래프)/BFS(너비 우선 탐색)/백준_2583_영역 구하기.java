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
public class Main {
    static int M;
    static int N;
    static int[][] arr;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int bfs(Pair p){
        Queue<Pair> queue = new LinkedList<>();
        queue.add(p);
        arr[p.x][p.y] = 1;      // 첫 돌 방문처리 잊지말기
        int sum = 0;        // 영역의 총합

        while(!queue.isEmpty()){
            Pair now = queue.poll();
            sum++;      

            for(int d = 0; d < 4; d++){
                int next_x = now.x + dx[d];
                int next_y = now.y + dy[d];
                
                // 제외시키기
                if(next_x < 0 || next_y < 0 || next_x >= M || next_y >= N) continue;
                if(arr[next_x][next_y] == 1) continue;

                // 방문처리 후 큐에 삽입, 영역의 넓이 추가.
                arr[next_x][next_y] = 1;
                queue.add(new Pair(next_x, next_y));
            }
        }
        return sum;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        arr = new int[M][N];
        visited = new boolean[M][N];
        for(int n = 0 ;n < K; n++){
            st = new StringTokenizer(br.readLine());

            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());

            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            for(int i = y1; i < y2; i++){
                for(int j = x1; j < x2; j++){
                    arr[i][j] = 1;
                }
            }
        }

        int cnt = 0;
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr[i].length; j++){
                if(arr[i][j] == 0) {
                    list.add(bfs(new Pair(i,j)));
                    cnt++;
                }
            }
        }

        System.out.println(cnt);
        Collections.sort(list);
        for(Integer i : list) System.out.print(i + " ");

    }
}