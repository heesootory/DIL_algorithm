import java.util.*;

public class Main {

    static int GCD(int a, int b) {
        int left = 0;
        while (true) {
            left = a % b;
            if (left == 0)
                break;
            a = b;
            b = left;
        }
        return b;
    }

    static int LCD(int a, int b) {
        int gcd = GCD(a, b);
        return (a / gcd * b / gcd * gcd);
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int _case = s.nextInt();
        while (_case-- > 0) {
            int M, N, x, y;
            M = s.nextInt();
            N = s.nextInt();
            x = s.nextInt();
            y = s.nextInt();

            int i = x;
            boolean is = false;
            int lcd = LCD(M, N);

            if (N == y)
                y = 0;
            while (i <= lcd) {
                if (i % N == y) {
                    is = true;
                    break;
                }
                i += M;
            }

            if (is)
                System.out.println(i);
            else
                System.out.println(-1);

        }
    }
}