import java.util.*;

public class Main {
    static long[] arr = new long[1001];

    public static void main(String[] args) {
        arr[0] = 0; arr[1] = 1; arr[2] = 3;
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();

        for(int i = 3; i<=n; i++){
            arr[i] = arr[i-1]  *2;
            if(i % 2 == 0) arr[i] += 1;
            else arr[i] -=1;
            arr[i]%= 10007;
        }
        System.out.println(arr[n]);

    }
}
