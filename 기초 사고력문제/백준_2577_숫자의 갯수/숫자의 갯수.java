import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int a = s.nextInt();
        int b = s.nextInt();
        int c = s.nextInt();
        int mul = a*b*c;
        int[] arr = new int[10];

        while(mul >= 1){
            int i = mul % 10;
            arr[i]++;
            mul /= 10;
        }
        for(int i = 0; i< arr.length; i++) System.out.println(arr[i]);
    }
}