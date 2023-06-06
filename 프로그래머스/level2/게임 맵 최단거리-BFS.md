# 게임 맵 최단거리


## 아이디어

* BFS


## 코드

```java
import java.util.*;

class Pair{
    int x = 0;
    int y = 0;
    public Pair(int x, int y){
        this.x = x;
        this.y = y;
    }
}

class Solution {
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static boolean[][] visited;
    static int answer;
    static int height;
    static int width;
    
    static void BFS(Pair p, int[][] maps){
        Queue<Pair> q = new LinkedList();
        q.add(p);
        visited[p.x][p.y] = true;
        int cnt = 0;

        while(!q.isEmpty()){
            int len = q.size();
            cnt++;
            
            for(int k = 0; k < len; k++){
                Pair s = q.poll();
                
                if(s.x == height-1 && s.y == width-1) answer = Math.max(answer, cnt);
                
                for(int d = 0; d < 4; d++){
                    int next_x = s.x + dx[d];
                    int next_y = s.y + dy[d];

                    if(next_x < 0 || next_x >= height || next_y < 0 || next_y >= width) 
                        continue;
                    if(visited[next_x][next_y] || maps[next_x][next_y] == 0) continue;

                    visited[next_x][next_y] = true;
                    q.add(new Pair(next_x, next_y));
                }
                
            }
            
        }
    }
    
    public int solution(int[][] maps) {
        height = maps.length;
        width = maps[0].length;
        visited = new boolean[height][width];
        
        BFS(new Pair(0,0), maps);
        
        return (answer == 0) ? -1 : answer;
    }
}
```
