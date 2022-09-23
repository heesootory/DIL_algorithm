import java.io.*;
import java.util.*;


class Pair{
    int x,y,z;
    Pair(int x, int y, int z){
        this.x = x;
        this.y = y;
        this.z = z;
    }
}

public class Main {
    static int M, N, H;
    static int total;
    static int[][][] arr;
    static int cnt;
    static int ans;
    static int[] dx = {-1,1,0,0,0,0};
    static int[] dy = {0,0,-1,1,0,0};
    static int[] dz = {0,0,0,0,-1,1};
    static Queue<Pair> queue;
    static void bfs(){
        while(!queue.isEmpty()){
            int len = queue.size();
            if(cnt == total) break;
            ans++;
            for(int l = 0; l < len; l++){
                Pair now = queue.poll();
                for(int d = 0; d < 6; d++){
                    int nx = now.x + dx[d];
                    int ny = now.y + dy[d];
                    int nz = now.z + dz[d];

                    if(nx < 0 || ny < 0 || nz < 0 || nx >= M || ny >= N || nz >= H) continue;
                    if(arr[nz][ny][nx] == 1 || arr[nz][ny][nx] == -1) continue;

                    arr[nz][ny][nx] = 1;
                    cnt++;

                    queue.add(new Pair(nx,ny,nz));
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        total = M * N * H;

        arr = new int[H][N][M];
        queue = new LinkedList<>();

        for(int h = 0; h < H; h++){
            for(int n = 0; n < N; n++){
                st = new StringTokenizer(br.readLine());
                for(int m = 0; m < M; m++){
                    arr[h][n][m] = Integer.parseInt(st.nextToken());
                    if(arr[h][n][m] == 1) {
                        cnt++;
                        queue.add(new Pair(m, n, h));
                    }
                    else if(arr[h][n][m] == -1) total--;
                }
            }
        }
        bfs();
        System.out.println((cnt == total) ? ans : -1);
    }


}

