import java.util.*;

public class Solution {

    public static void main(String[] args) throws Exception {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        int _case = 1;

        while(t-- > 0){
            int n = s.nextInt();
            int k = s.nextInt();

            int[][] arr = new int[n][n];
            for(int i = 0; i< n; i++){
                for(int j = 0; j < n; j++){
                    arr[i][j] = s.nextInt();
                }
            }

            int sum = 0;
            for(int i =0; i< n; i++){               //가로줄
                int cnt = 0;
                for(int j = 0; j< n; j++) {
                    if(j == n-1) {                  // 행렬의 끝부분에 연속 3개 등장
                        if (arr[i][j] == 0) cnt = 0;
                        else cnt++;
                        if (cnt == k) sum++;
                    }
                    else {                              //끝부분이 아닐때 연속 3개 등장. -> 3개 넘어가면 카운트x
                        if (arr[i][j] == 0) cnt = 0;
                        else cnt++;
                        if ((cnt == k) && (arr[i][j + 1] == 0)) sum++;
                    }
                }
            }

            for(int i =0; i< n; i++){           //세로줄
                int cnt = 0;
                for(int j = 0; j< n; j++){
                    if(j == n-1) {                  // 행렬의 끝부분에 연속 3개 등장
                        if (arr[j][i] == 0) cnt = 0;
                        else cnt++;
                        if (cnt == k) sum++;
                    }
                    else {                  //끝부분이 아닐때 연속 3개 등장. -> 3개 넘어가면 카운트x
                        if (arr[j][i] == 0) cnt = 0;
                        else cnt++;
                        if ((cnt == k) && (arr[j+1][i] == 0)) sum++;
                    }
                }
            }

            System.out.println("#" + _case + " " + sum);

            _case++;
        }




    }
}