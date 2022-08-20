import java.io.*;
import java.util.*;

public class Main {
    enum way{
        down_left,
        down,
        down_right,
        right
    }
    static int[][] way_arr = {{-1, -1}, {-1, 0}, {-1, 1}, {0, 1}};
    static char[][] map;
    static int n;
    static boolean check(){
        for(int i = 0; i < map.length; i++){
            for(int j = 0; j < map[i].length; j++){
                if(map[i][j] == 'o'){
                    for(way w : way.values()){          // down_left, down, down_right, right
                        int next_x = i + way_arr[w.ordinal()][0];
                        int next_y = j + way_arr[w.ordinal()][1];

                        if(next_x >= n || next_x < 0 || next_y >= n || next_y < 0) continue;

                        if(map[next_x][next_y] == 'o'){
                            int cnt = 0;
                            for(int h = 0; h < 3; h++){
                                next_x += way_arr[w.ordinal()][0];
                                next_y += way_arr[w.ordinal()][1];

                                if(next_x >= n || next_x < 0 || next_y >= n || next_y < 0) break;

                                if(map[next_x][next_y] == 'o') cnt++;
                                else break;
                            }
                            if(cnt == 3) return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int test = Integer.parseInt(br.readLine());

        for(int t = 1; t <= test; t++) {
            n = Integer.parseInt(br.readLine());
            map = new char[n][n];

            for(int i = 0; i < map.length; i++){
                String str = br.readLine();
                for(int j = 0; j < map[i].length; j++){
                    map[i][j] = str.charAt(j);
                }
            }

            String ans = (check()) ? "YES" : "NO";

            System.out.printf("#%d %s\n", t, ans);
        }
    }
}
