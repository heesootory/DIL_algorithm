import java.util.*;

public class Main {
    static long[] stairs = new long[302];
    static long[] sum = new long[302];

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        for(int i = 1; i <= n; i++){
            stairs[i] = s.nextInt();
        }
        sum[1] = stairs[1];
        sum[2] = stairs[1] + stairs[2];
        sum[3] = Math.max(stairs[1], stairs[2]) + stairs[3];
        for(int i = 4; i<=n; i++){
            sum[i] = Math.max(sum[i-3] + stairs[i-1], sum[i-2]) + stairs[i];
        }

        System.out.println(sum[n]);

    }

}
