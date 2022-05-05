import java.util.*;

public class Main {
    static int count_zero(int n, int k) {
        int cnt = 0;
        for (long i = k; i <= n; i *= k) {
            cnt += (n / i);
        }
        return cnt;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int n = s.nextInt();
        int m = s.nextInt();

        int f = count_zero(n, 5) - count_zero(m, 5) - count_zero(n - m, 5);
        int t = count_zero(n, 2) - count_zero(m, 2) - count_zero(n - m, 2);

        System.out.println(Math.min(f, t));
    }
}