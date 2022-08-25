import java.io.*;
import java.util.*;

class Pair implements Comparable<Pair>{
    int x;
    int y;
    Pair(int x, int y){
        this.x = x;
        this.y = y;
    }
    @Override
    public int compareTo(Pair o){
        return this.y - o.y;
    }
}

public class Main {
    static final int size = 19;
    static int[][] arr;
    static int[] dx = {0, 1, 1, 1};
    static int[] dy = {1, 1, 0, -1};
    static List<Pair> list;
    static boolean win = false;
    static boolean outmap(int x, int y){
        if(x < 0 || x >= size || y < 0 || y >= size) return true;
        return false;
    }
    static boolean check(int x, int y, int num){
        int cnt = 1;
        loop:
        for(int d = 0; d < 4; d++){
            list = new ArrayList<>();
            list.add(new Pair(x,y));        //첫 번쨰 돌 저장
            int next_x = x + dx[d];
            int next_y = y + dy[d];

            int past_x = x - dx[d];
            int past_y = y - dy[d];

            while (true) {
                // 바둑판을 벗어나면 제외.
                if(outmap(next_x, next_y)) break;

                // 다음 칸 검사
                if(arr[next_x][next_y] == num) {
                    //System.out.println(next_x + " " + next_y);
                    list.add(new Pair(next_x, next_y));     // 5개의 돌 저장
                    cnt++;
                }
                else break;

                // 1칸 다음칸 
                next_x += dx[d];
                next_y += dy[d];

                if(cnt == 5){       // 5개가 연속일때
                    if(outmap(next_x, next_y) || (outmap(past_x, past_y))){
                        if(outmap(next_x, next_y) && outmap(past_x, past_y)) return true;
                        if(outmap(next_x, next_y) && (arr[past_x][past_y] != num)) return true;
                        if(outmap(past_x, past_y) && (arr[next_x][next_y] != num)) return true;
                    }
                    else if ((arr[past_x][past_y] != num) && (arr[next_x][next_y] != num)) return true;
                    else continue loop;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        arr = new int[size][size];

        for(int i = 0; i < arr.length; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < arr[i].length; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int ans = 0;
        loop:
        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr[i].length; j++){
                if(arr[i][j] == 1 || arr[i][j] == 2){
                    if(check(i, j, arr[i][j])){
                        ans = arr[i][j];
                        break loop;
                    }
                }
            }
        }
//        Collections.sort(list);
//        for(Pair p : list) System.out.println(p.x + " " + p.y);

        System.out.println(ans);
        Pair ans_dol = list.get(0);
        System.out.println((ans_dol.x+1) + " " + (ans_dol.y+1));
    }
}