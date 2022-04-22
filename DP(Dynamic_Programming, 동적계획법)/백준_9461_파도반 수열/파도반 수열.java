import java.util.*;

public class Main {
    static long[] arr = new long[101];

    public static void main(String[] args) {
        arr[1] = 1; arr[2] = 1; arr[3] = 1; arr[4] = 2; arr[5] = 2;
        Scanner s = new Scanner(System.in);
        int T = s.nextInt();
        for(int i = 0; i<T; i++){
            int n = s.nextInt();
            if(n < 6) System.out.println(arr[n]);
            else{
                for(int j = 6; j<=n; j++){
                    arr[j] = arr[j-1] + arr[j-5];
                }
                System.out.println(arr[n]);
            }
        }

    }
}
