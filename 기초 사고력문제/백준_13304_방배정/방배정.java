import java.util.*;

public class Main{
    public static int room( int stu, int k){
        int sum_room =0;
        sum_room += (stu/k);
        if(stu % k != 0) sum_room+=1;
        return sum_room;
    }
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int n, k;
        n = s.nextInt();
        k = s.nextInt();

        int[][] arr = new int[2][6];
        int a,b;
        while(n-- > 0){
            a = s.nextInt();
            b = s.nextInt();
            arr[a][b-1]++;
        }
        int smw = arr[0][0] + arr[1][0] + arr[0][1] + arr[1][1];
        int mm = arr[1][2] + arr[1][3];
        int mw = arr[0][2] + arr[0][3];
        int hm = arr[1][4] + arr[1][5];
        int hw = arr[0][4] + arr[0][5];
        int sum = 0;
        sum += room(smw, k);
        sum += room(mm, k);
        sum += room(mw, k);
        sum += room(hm, k);
        sum += room(hw, k);
        System.out.println(sum);

    }
}