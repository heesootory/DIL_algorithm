import java.util.*;


class Pair{         // 좌표를 이용하기 위해, pair class 직접 만들어서 사용
    int x;
    int y;

    public Pair(int x, int y){
        this.x = x;
        this.y = y;
    }
}

public class Solution {
    static int[][] new_arr = new int[101][101];         // 기존배열을 가지고, 경로에 있는 숫자의 총합이 작은 것들만 저장하는 새로운 배열.

    static void BFS(Pair p, int n, int[][] arr){
        Queue<Pair> q = new LinkedList();
        q.add(p);

        while(q.isEmpty() == false){
            Pair f = q.peek();
            q.poll();
            // 상, 하, 좌, 우 모두 확인 - 최단 거리가 아닌, 가중치들의 합이 최소인 경우이므로, 미로와 같이 모든 경로를 확인해야함.
            // 다익스트라 알고리즘

            if(f.x > 0){        //상 방향
                if (new_arr[f.x - 1][f.y] > new_arr[f.x][f.y] + arr[f.x - 1][f.y]) {        //기존의 있는 값보다, 작을 때만 저장하면서 체크
                    new_arr[f.x - 1][f.y] = new_arr[f.x][f.y] + arr[f.x - 1][f.y];
                    q.add(new Pair(f.x - 1, f.y));          // 기존의 값보다 작을때만 저장하고 큐에 저장해서 다음경로를 간다. -> 큰 경우는 경로에 있을 필요도 없음.
                }
            }
            if(f.y > 0){                // 우 방향
                if(new_arr[f.x][f.y-1] > new_arr[f.x][f.y] + arr[f.x][f.y-1]){          //기존의 있는 값보다, 작을 때만 저장하면서 체크
                    new_arr[f.x][f.y-1] = new_arr[f.x][f.y] + arr[f.x][f.y-1];
                    q.add(new Pair(f.x, f.y-1));            // 기존의 값보다 작을때만 저장하고 큐에 저장해서 다음경로를 간다. -> 큰 경우는 경로에 있을 필요도 없음.
                }
            }
            if(f.x + 1 < n) {               //하 방향
                if (new_arr[f.x + 1][f.y] > new_arr[f.x][f.y] + arr[f.x + 1][f.y]) {        //기존의 있는 값보다, 작을 때만 저장하면서 체크
                    new_arr[f.x + 1][f.y] = new_arr[f.x][f.y] + arr[f.x + 1][f.y];
                    q.add(new Pair(f.x + 1, f.y));          // 기존의 값보다 작을때만 저장하고 큐에 저장해서 다음경로를 간다. -> 큰 경우는 경로에 있을 필요도 없음.
                }
            }
            if(f.y + 1 < n){                // 우 방향
                if(new_arr[f.x][f.y+1] > new_arr[f.x][f.y] + arr[f.x][f.y+1]){          //기존의 있는 값보다, 작을 때만 저장하면서 체크
                    new_arr[f.x][f.y+1] = new_arr[f.x][f.y] + arr[f.x][f.y+1];
                    q.add(new Pair(f.x, f.y+1));            // 기존의 값보다 작을때만 저장하고 큐에 저장해서 다음경로를 간다. -> 큰 경우는 경로에 있을 필요도 없음.
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        int _case = 1;

        while(t-- > 0){
            int n = s.nextInt();
            for(int i = 0; i< 101; i++) Arrays.fill(new_arr[i], Integer.MAX_VALUE-1);       // 새로운 배열 매 케이스마다 초기화
            new_arr[0][0] = 0;                  //start 지점은 항상 0으로.
            int[][] arr = new int[n][n];
            for(int i = 0 ; i< n; i++){
                String str = s.next();
                for(int j = 0; j < n; j++) {
                    arr[i][j] = (int)(str.charAt(j) - 48);          //문자열 배열로 들어오는 input 숫자 배열로 바꿈.
                }
            }
            Pair p = new Pair(0,0);
            BFS(p, n, arr);
//            for(int i = 0; i< n; i++) {           // new_arr 배열 출력 - test용
//                for (int j = 0; j < n; j++) {
//                    System.out.print(new_arr[i][j] + " ");
//                }
//                System.out.println();
//            }
            System.out.println("#" +_case +  " " + new_arr[n-1][n-1]);
            _case++;
        }

    }
}