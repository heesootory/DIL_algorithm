import java.io.*;
import java.util.*;

public class Main {
    static long[] d = new long[100];

    public static long dp(int n){
        //1. base check
        if(n <= 1) return n;

        //2. memoization
        if(d[n] > 0) return d[n];

        //3. recurrence relation
        d[n] = dp(n-1) + dp(n-2);

        return d[n];
    }

    public static void main(String[] args) throws IOException {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        System.out.println(dp(n));

    }
}
