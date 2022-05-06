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

        int a = 0;
        while (true) {
            int n = s.nextInt();
            if (n == 0)
                break;

            for (int i = 3; i < n; i += 2) {
                if (is_prime(i) && is_prime(n - i)) {
                    a = i;
                    break;
                }
            }
            if (a == 0)
                System.out.println("Goldbach's conjecture is wrong.");
            else
                System.out.println(n + " = " + a + " + " + (n - a));
        }
    }
}