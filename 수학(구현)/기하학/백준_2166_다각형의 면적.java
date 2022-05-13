import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int N = s.nextInt();
        int x, y;
        int first_x = 0, first_y = 0;
        int past_x = 0, past_y = 0;
        long sum1 = 0;
        long sum2 = 0;

        for (int i = 0; i < N; i++) {
            x = s.nextInt();
            y = s.nextInt();
            if (i == 0) {
                first_x = x;
                first_y = y;
            }

            sum1 += ((long) past_x * y);
            sum2 += ((long) past_y * x);
            past_x = x;
            past_y = y;

        }
        sum1 += ((long) past_x * first_y);
        sum2 += ((long) past_y * first_x);
        long max_sum = Math.max(sum1, sum2);
        long min_sum = Math.min(sum1, sum2);
        double ans = (double) (max_sum - min_sum) / 2.0;
        ans = Math.round(ans * 10) / 10.0;
        System.out.println(String.format("%.1f", ans));
    }
}