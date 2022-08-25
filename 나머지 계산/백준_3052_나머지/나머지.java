import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int[] arr = new int[42];

        int num = 10;
        int a = 0;
        while(num-- > 0){
            a = s.nextInt();
            arr[a%42]++;
        }
        int cnt = 0;
        for(int i = 0; i< arr.length; i++){
            if(arr[i] > 0) cnt++;
        }
        System.out.println(cnt);
    }
}