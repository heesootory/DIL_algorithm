import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int[][] apt = new int[15][15];

        for(int i = 0; i < apt.length; i++){
            for(int j = 1; j< apt[i].length; j++ ){
                if(i == 0) apt[i][j] = j;
                else{
                    if(j == 1) apt[i][j] = j;
                    else apt[i][j] = apt[i-1][j] + apt[i][j-1];
                }
            }
        }
        int t = s.nextInt();
        int k, n;
        while(t-- > 0){
            k = s.nextInt();
            n = s.nextInt();
            System.out.println(apt[k][n]);
        }


    }
}