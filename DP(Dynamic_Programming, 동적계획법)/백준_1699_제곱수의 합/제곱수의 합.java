import java.util.*;

public class Main {
    static int[] arr = new int[100000];

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        int input = s.nextInt();

        for(int i = 0; i<= input; i++){
            arr[i] = i;
            for(int j = 0; j*j <= i; j++){
                arr[i] = Math.min(arr[i], arr[i-j*j] + 1);
            }
        }

        System.out.println(arr[input]);
    }

}
