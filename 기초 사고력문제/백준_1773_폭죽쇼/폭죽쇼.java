import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int n,c;
        n = s.nextInt();
        c = s.nextInt();
        int[] time = new int[n];
        boolean[] fire = new boolean[2000001];
        for(int i = 0; i< n; i++) time[i] = s.nextInt();

        int cnt = 0;
        for(int i = 0; i< n; i++){
            for(int j = time[i]; j <= c; j +=time[i]){
                if(fire[j]) continue;
                fire[j] = true;
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}