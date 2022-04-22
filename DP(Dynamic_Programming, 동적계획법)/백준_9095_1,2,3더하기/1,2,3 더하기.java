import java.util.*;

public class Main {
    static int[] arr = new int[11];

    public static void main(String[] args) {
        arr[1] = 1; arr[2] = 2; arr[3] = 4;
        Scanner s = new Scanner(System.in);
        int T = s.nextInt();
        for(int i = 0; i<T; i++){
            int n = s.nextInt();
            if(arr[n] > 0) System.out.println(arr[n]);
            else{
                for(int j = 4; j <=n; j++){
                    arr[j] = arr[j-1] + arr[j-2] + arr[j-3];
                }
                System.out.println(arr[n]);
            }
        }

    }
}
