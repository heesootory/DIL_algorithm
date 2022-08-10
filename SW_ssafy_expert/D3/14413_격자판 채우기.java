import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int m;
    static int[] dx = new int[] {-1,1, 0,0};
    static int[] dy = new int[] {0,0,-1,1};
    static boolean check;
    static boolean change_arr(char[][] arr, int i, int j, char c){
        for(int d = 0; d < 4; d++){
            int nx = i + dx[d];
            int ny = j + dy[d];

            if(nx < 0 || ny < 0 || nx >= n || ny >= m) continue;

            if(arr[nx][ny] == c) return false;

            if(c == '#') arr[nx][ny] = '.';
            else arr[nx][ny] = '#';
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int t = Integer.parseInt(st.nextToken());

        for(int k = 1; k<= t; k++) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            char[][] arr = new char[n][m];

            for(int i = 0; i<n; i++){
                String s = br.readLine();
                for(int j = 0; j< m; j++){
                    arr[i][j] = s.charAt(j);
                }
            }

            for(int i = 0; i<n; i++){
                for(int j = 0; j < m; j++){
                    check = true;
                    if(arr[i][j] == '#') check = change_arr(arr, i, j, '#');
                    else if(arr[i][j] =='.') check = change_arr(arr, i, j, '.');
                    if(!check) break;
                }
                if(!check) break;
            }

            if(check) System.out.println("#" + k + " " + "possible");
            else System.out.println("#" + k + " " + "impossible");
        }

    }
}
