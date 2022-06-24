import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int p = s.nextInt();
        int m = n;
        int[] arr = new int[1001];
        int cnt = 0;

        while(true){
            int i = (n*m) % p;
            if(arr[i] > 2) break;
            arr[i]++;
            m = i;
            if(arr[i] == 2) cnt++;
        }
        System.out.println(cnt);
    }
}