import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

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
    static ArrayList<Integer> house_group = new ArrayList();
    static int[][] house;
    static boolean[][] visited;             // 방문 기록을 하는 배열을 따로 두고, 체크한 것을 큐에 넣지 않아야 메모리초과가 나지 않는다.
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static void BFS(Pair s){
        int cnt = 0;
        Queue<Pair> q = new LinkedList();
        q.add(s);
        visited[s.x][s.y] = false;

        while(!q.isEmpty()) {
            Pair f = q.peek();
            q.poll();
            cnt++;        // 큐에 들어온 집주소는 무조건 처음 방문이므로, 큐에서 나갈때마다 세면 됨.

            for (int k = 0; k < 4; k++) {             // 4방향으로 탐색
                int next_x = f.x + dx[k];
                int next_y = f.y + dy[k];

                if (next_x < 0 || next_x >= n || next_y < 0 || next_y >= n) continue;

                if (house[next_x][next_y] == 1 && visited[next_x][next_y]) {        //집 && 방문 안한
                    q.add(new Pair(next_x, next_y));     // 카운트 할집 큐에 삽입.
                    visited[next_x][next_y] = false;
                }
            }
        }
        house_group.add(cnt);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        house = new int[n][n];
        visited = new boolean[n][n];

        for(int i =0; i<n; i++){
            String str = br.readLine();
            for(int j =0 ; j< n; j++){
                house[i][j] = Character.getNumericValue(str.charAt(j));     // char 형태를 아스키코드가 아닌 숫자형으로 바로 변환해줌.
                if(house[i][j] == 1) visited[i][j] = true;
            }
        }

        for(int i = 0 ; i < n; i++){
            for(int j = 0; j < n; j++){
                if(house[i][j] == 1 && visited[i][j]) BFS(new Pair(i,j));
            }
        }

        System.out.println(house_group.size());
        Collections.sort(house_group);          //ArrayList 를 오름차순으로 정렬.
        for(int i =0; i< house_group.size(); i++) System.out.println(house_group.get(i));

    }
}
