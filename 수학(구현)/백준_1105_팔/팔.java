import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int L = s.nextInt();
        int R = s.nextInt();

        int min_cnt = 10;
        for (int i = L; i <= R; i++) {
            int n = i;
            int cnt = 0;
            while (n > 0) {
                if (n % 10 == 8)
                    cnt++;
                n /= 10;
            }
            if (cnt < min_cnt)
                min_cnt = cnt;
            if (min_cnt == 0)
                break;
        }
        System.out.println(min_cnt);

    }
}