import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 *  전형적인 bfs 문제이지만, 나처럼 visited 여부를 생성하지 않고 풀게되면, 메모리 초과가 흔히 일어나게 된다.
 *  그 이유는 큐에 이미 존재하는 값이 두번 이상 들어가기 때문인데, 그걸 방지 하기 위해, 사방향탐색과 조건이 일치할때
 *  그 즉시 배열의 값을 바꿔주는 게 필요하다. -> 좋지는 않은 방법
 */

class  Pair{
    int x = 0;
    int y = 0;
    public Pair(int x, int y){
        this.x = x;
        this.y = y;
    }
}
public class test {
    static int n;
    static int m;
    static int[][] arr;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};

    static void BFS(Pair p){
        Queue<Pair> q = new LinkedList();
        q.add(p);

        while(!q.isEmpty()){
            Pair f = q.peek(); q.poll();
            arr[f.x][f.y] = 0;              // 이걸로도 배열에서는 문제 없지만, 큐에 겹치는 수가 이미 들어와서 메모리 초과의 원인

            for(int i = 0; i < 4; i++){
                int next_x = f.x + dx[i];
                int next_y = f.y + dy[i];

                if(next_x <0 || next_y < 0 || next_x >= n || next_y >= m) continue;

                if(arr[next_x][next_y] == 1){
                    q.add(new Pair(next_x, next_y));
                    arr[next_x][next_y] = 0;        // 여기서 즉시 바꿔줌으로서, 메모리 초과 막음 -> 큐에 겹치는 수가 들어가지 않게
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int t = Integer.parseInt(st.nextToken());
        while(t-- > 0){
            st = new StringTokenizer(br.readLine());
            m = Integer.parseInt(st.nextToken());
            n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            arr = new int[n][m];

            for(int i = 0; i < k; i++){
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                arr[b][a] = 1;
            }

            int cnt = 0;

            for(int i =0; i< arr.length; i++){
                for(int j = 0; j < arr[i].length; j++){
                    if(arr[i][j] == 1) {
                        BFS(new Pair(i,j));
                        cnt++;
                    }
                }
            }
            System.out.println(cnt);

        }

    }
}
