import java.util.*;

public class Main{

    public static void main(String[] args){
        int[] month = {31,28,31,30,31,30,31,31,30,31,30,31};
        String[] week = {"MON", "TUE", "WED", "THU", "FRI", "SAT", "SUN"};

        Scanner s = new Scanner(System.in);
        int m = s.nextInt();
        int d = s.nextInt();

        int sum = 0;
        for(int i = 0; i< m-1; i++) sum += month[i];
        sum += (d-1);
        System.out.println(week[sum % 7]);
    }
}