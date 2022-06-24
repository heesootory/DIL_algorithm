import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int min1 = 2000;
        for(int i =0; i<3; i++){
            int burger = s.nextInt();
            if(burger < min1) min1 = burger;
        }
        int min2 = 2000;
        for(int i =0; i<2; i++){
            int drink = s.nextInt();
            if(drink < min2) min2 = drink;
        }
        System.out.println(min1 + min2 - 50);
    }
}