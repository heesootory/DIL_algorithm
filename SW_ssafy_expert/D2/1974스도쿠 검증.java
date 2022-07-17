import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        int _case = 1;
        int n = 9;

        while(t-- > 0) {
            Boolean check = true;
            int[][] sdoku = new int[n][n];

            for(int i = 0; i< n; i++){
                for(int j = 0; j < n; j++){
                    sdoku[i][j] = s.nextInt();
                }
            }

            //가로,세로 라인 확인
            for(int i = 0 ; i< n ; i++){
                int[] check_arr = new int[10];      //가로 체크
                int[] check_arr2 = new int[10];     //세로 체크
                for(int j = 0;  j <n; j++){
                    if(++check_arr[sdoku[i][j]] > 1){
                        check = false; break;
                    }
                    if(++check_arr2[sdoku[j][i]] > 1){
                        check = false; break;
                    }
                }
            }

            for(int i = 0; i < n; i+=3){
                for(int j = 0;  j < n; j+=3){
                    int[] check_arr = new int[10];      // 3 x 3체크
                    for(int a = i; a < i+3; a++){
                        for(int b = j; b < j+3; b++){
                            if(++check_arr[sdoku[a][b]] > 1){
                                check = false; break;
                            }
                        }
                    }
                }
            }

            int check_num = (check) ? 1 : 0;
            System.out.println("#" + _case + " " + check_num);

            _case++;
        }
    }
}