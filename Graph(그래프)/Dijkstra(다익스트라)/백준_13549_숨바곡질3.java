import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 *  방문은 안한 곳이면, 이전 시간으로 갱신.
 *  방문을 한 곳이면, 이전시간과 저장된 시간을 비교해서 더 작은 시간으로 갱신하는 방법으로
 *  모든 시간좌표를 최소 시간으로 저장하며 진행한다.
 */

class Pair{
    int x = 0;      //위치
    int y = 0;      //시간
    public Pair(int x, int y){
        this.x = x;
        this.y = y;
    }
}

public class Main {
    static final int len = 100000;
    static boolean[] visited = new boolean[100001];     //방문 여부 저장
    static int[] time = new int[100001];        // 지점의 최소 도착 시간 저장
    static void BFS(int n, int k){
        Queue<Integer> q = new LinkedList();
        q.add(n);
        visited[n] = true;

        while(!q.isEmpty()){
            int f = q.peek(); q.poll();

            if(f + 1 <= 100000 ) {
                if(!visited[f+1]) {     //방문을 안했다면
                    time[f+1] = time[f] + 1;        // 이전 시간 비교없이 저장
                    visited[f+1] = true;
                    q.add(f+1);
                }
                else{                   // 이미 방문 한 곳이면
                    if(time[f+1] > time[f] + 1){        // 이전 시간에서 추가한 시간과 저장된 최소시간 비교
                        q.add(f+1);
                        time[f+1] = time[f] + 1;
                    }
                }
            }
            if(f - 1 >= 0 ) {
                if(!visited[f-1]){      //방문을 안했다면
                    time[f-1] = time[f] + 1;        // 이전 시간 비교없이 저장
                    visited[f-1] = true;
                    q.add(f-1);
                }
                else{                   // 이미 방문 한 곳이면
                    if(time[f-1] > time[f] + 1){        // 이전 시간에서 추가한 시간과 저장된 최소시간 비교
                        q.add(f-1);
                        time[f-1] = time[f] + 1;
                    }
                }
            }
            if(f * 2 <= 100000 ) {
                if(!visited[f*2]){      //방문을 안했다면
                    time[f*2] = time[f];        // 이전 시간 비교없이 저장
                    visited[f*2] = true;
                    q.add(f*2);
                }else{                  // 이미 방문 한 곳이면
                    if(time[f*2] > time[f]){        // 이전 시간에서 추가한 시간과 저장된 최소시간 비교
                        q.add(f*2);
                        time[f*2] = time[f];
                    }
                }
            }
        }
        System.out.println(time[k]);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        BFS(n,k);



    }
}