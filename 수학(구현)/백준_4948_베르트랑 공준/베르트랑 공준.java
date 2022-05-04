import java.util.*;

public class Main {
    static Boolean is_prime(int n) {
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int n;
        while (true) {
            n = s.nextInt();
            int count = 0;
            if (n == 0)
                break;

            for (int i = n + 1; i <= 2 * n; i++) {
                if (is_prime(i))
                    count++;
            }
            System.out.println(count);
        }
    }
}