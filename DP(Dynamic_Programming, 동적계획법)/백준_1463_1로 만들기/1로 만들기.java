import java.util.*;

public class Main {

    static int min = 1000000;
    static void dp(int x, int count){
        if(x <= 1){
            if(count < min) min = count;
            return;
        }

        if(x % 3 == 0){
            if( count > min ) return;
            dp(x/3, count+1);
        }
        if(x % 2 == 0){
            if(count > min) return;
            dp(x/2, count+1);
        }
        if(count> min) return;
        dp(x-1, count+1);

        return;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int input = s.nextInt();
        dp(input, 0);
        System.out.println(min);


    }

}
