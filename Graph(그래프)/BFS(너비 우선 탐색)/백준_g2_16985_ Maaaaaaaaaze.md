# 16985 - Maaaaaaaaaze



## 아이디어

* 순열, 중복 순열, bfs를 모두 활용해야하는 문제.

* 미로의 층을 5개의 레이어로 쌓아 미로를 만드는 경우의 수 : 순열
* 만들어진 미로를 가지고, 각층별로 회전시켜보는 경우 : 중복 순열    
    - 각 층마다 회전수가 같을 수 있으므로.

* 완성된 미로를 가지고, 출발지부터 도착지점까지 갈수 있는 최소거리를 찾기 : bfs

* 🎯 미로나 길찾기의 문제가 나왔을때, 항상 출발지와 도착지를 양쪽으로 생각해보는게 중요!
    - 이 문제에서도 가지치기가 가능!


## 코드

```java
import java.io.*;
import java.util.*;

class Maze_Runner{
    int z,x,y;
    Maze_Runner(int z, int x, int y){
        this.z = z;
        this.x = x;
        this.y = y;
    }
}

public class Main {
    static int min = Integer.MAX_VALUE;
    static final int size = 5;
    static boolean[][][] visited;
    static int[][][] maze;
    static boolean[] check;
    static int[] order;
    static int[] dx = {-1,1,0,0,0,0};
    static int[] dy = {0,0,-1,1,0,0};
    static int[] dz = {0,0,0,0,-1,1};

//    static void print(int[][][] maze){
//        for(int k = 0; k < size; k++){
//            for(int i = 0 ; i < size; i++){
//                for(int j = 0; j < size; j++){
//                    System.out.print(maze[k][i][j] + " ");
//                }
//                System.out.println();
//            }
//        }
//    }

    static int bfs(Maze_Runner mr, int[][][] copy_maze){            // 완성된 미로 탐색.
        visited = new boolean[size][size][size];
        Queue<Maze_Runner> queue = new LinkedList<>();
        queue.add(mr);
        visited[mr.z][mr.x][mr.y] = true;
        int move = 0;

        while(!queue.isEmpty()){
            int len = queue.size();

            for(int q = 0; q < len; q++){
                Maze_Runner now = queue.poll();

                if(now.z == size - 1 && now.x == size - 1 && now.y == size - 1 ) return move;

                for(int d = 0; d < 6; d++){
                    int nz = now.z + dz[d];
                    int nx = now.x + dx[d];
                    int ny = now.y + dy[d];

                    if(nz < 0 || nx < 0 || ny < 0 || nz >= size || nx >= size || ny >= size) continue;
                    if(visited[nz][nx][ny]) continue;
                    if(copy_maze[nz][nx][ny] == 0) continue;

                    visited[nz][nx][ny] = true;
                    queue.add(new Maze_Runner(nz, nx, ny));
                }
            }
            move++;
        }
        return Integer.MAX_VALUE;
    }

    static int[][][] pivot_maze(int idx, int[][][] copy_maze, int cnt){     // idx 층을 cnt만큼 90도 회전시키는 함수
        int[][][] new_maze = new int[size][size][size];             // 일단 새로운 배열에 복사 해놓고.
        for(int k = 0; k < size; k++){
            for(int i = 0; i < size; i++){
                new_maze[k][i] = copy_maze[k][i].clone();
            }
        }
        // cnt 만큼 90도 회전
        while(cnt-- > 0) {
            int[][] tmp_arr = new int[size][size];
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    tmp_arr[i][j] = new_maze[idx][(size - 1) - j][i];
                    // 2차원 배열 교환. - 이렇게 하지않으면 배열이 돌면서, 이미 돌아간 배열을 복사함.
                }
            }
            for (int i = 0; i < size; i++) {
                new_maze[idx][i] = tmp_arr[i].clone();
            }
        }
        return new_maze;
    }

    static void maze_rotate(int idx, int[][][] copy_maze){     // 0 ~ 3을 5가지 뽑는 중복 순열. -> 회전할 메이즈 선택.
        if(idx == size){
            if(copy_maze[0][0][0] == 1 && copy_maze[4][4][4] == 1){     // 출발지와 도착지가 모두 갈수있어야 bfs탐색시작 - 가지치기.
                int ans = bfs(new Maze_Runner(0,0,0), copy_maze);
                if(ans != 0) min = Math.min(ans, min);
            }
            return;
        }

        for(int i = 0; i < 4; i++){
            maze_rotate(idx + 1, pivot_maze(idx, copy_maze, i));        // idx에 해당하는 함수를 i번 90도 회전.
        }
    }

    static void make_maze(int idx){                // 순열로 메이즈 쌓기
        if(idx == size){
            int[][][] copy_maze = new int[size][size][size];
            // 순열대로 메이즈 층을 구성.
            for(int k = 0; k < size; k++){
                for(int i = 0; i < size; i++){
                    copy_maze[k][i] = maze[order[k]][i].clone();
                }
            }
            maze_rotate(0, copy_maze);
            return;
        }

        for(int i = 0 ; i < size; i++){
            if(check[i]) continue;
            check[i] = true;
            order[idx] = i;
            make_maze(idx + 1);
            check[i] = false;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        maze = new int[size][size][size];
        check = new boolean[size];
        order = new int[size];

        for(int k = 0; k < size; k++){
            for(int i = 0 ; i < size; i++){
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j < size; j++){
                    maze[k][i][j] = Integer.parseInt(st.nextToken());
                }
            }
        }
        make_maze(0);
        System.out.println((min == Integer.MAX_VALUE) ? -1 : min);

    }
}

```