import java.util.*;

public class Main {
    static long[] arr = new long[91];

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        arr[1] = 1;

        for(int i = 2; i<= n; i++){
            arr[i] = arr[i-1] + arr[i-2];
        }

        System.out.println(arr[n]);
    }

}
