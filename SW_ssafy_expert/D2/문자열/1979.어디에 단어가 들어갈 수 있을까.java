import java.io.*;
import java.util.*;

/**
 * 문자열 탐색 문제
 *
 * 문자열이 가로만 배열되어 있다면, String(문자열)화 시켜서 subString으로 문자열을 잘라가며 확인하는게 베스트.
 * 하지만 이문제 처럼, 배열로 되어있는 문자열 탐색의 경우, 세로열이 String화 시키기 어려움으로,
 * 경계선까지 만들어진 배열을 정확히 만들고, 그 칸자체를 배열에 하나씩 키워맞춰본다는 식으로
 * n칸씩 가로/세로를 탐새하는게 훨씬 속도도 빠르고 정확함.
 *
 */


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for(int t = 1; t <= T; t++){
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            int[][] arr = new int[n+2][n+2];

            int[] norm = new int[k+2];          // 01110 기준 배열 만듬 - 안정영역을 포함해서 기준 칸 만들기. -> 곙계가 뚜렷해서 정확함.
            for(int i = 0; i< norm.length; i++){
                if(i == 0 || i == norm.length-1) norm[i] = 0;
                else norm[i] = 1;
            }

            for(int i = 1; i < n+1; i++){     // 배열 입력 받기 - 안전영역을 포함한 배열 만들기
                st = new StringTokenizer(br.readLine());
                for(int j = 1; j < n+1; j++){
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int ans = 0;

            for(int i = 1; i < n+1; i++){          // 가로열 검사
                for(int j = 0; j <= n-k; j++){
                    boolean check = true;
                    for(int l = 0; l < k+2; l++){
                        if(norm[l] != arr[i][j+l]){
                            check = false; break;
                        }
                    }
                    if(check) ans++;
                }
            }

            for(int i = 1; i < n+1; i++){          // 세로열 검사
                for(int j = 0; j <= n-k; j++){
                    boolean check = true;
                    for(int l = 0; l < k+2; l++){
                        if(norm[l] != arr[j+l][i]){
                            check = false; break;
                        }
                    }
                    if(check) ans++;
                }
            }
            System.out.println("#" + t + " " + ans);
        }

    }
}