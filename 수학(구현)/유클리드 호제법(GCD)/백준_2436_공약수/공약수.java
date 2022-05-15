import java.util.*;

public class Main {
    static int GCD(int a, int b) {
        int p = Math.max(a, b);
        int q = Math.min(a, b);
        int left = p % q;
        while (left != 0) {
            p = q;
            q = left;
            left = p % q;
        }
        return q;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int g = s.nextInt();
        int l = s.nextInt();

        if (g == l)
            System.out.println(g + " " + g);
        else {
            int p = l / g;
            int sum = p + 2;
            int a = 0, b = 0;
            for (int i = 1; i < p; i++) {
                if (p % i == 0) {
                    int j = p / i;
                    if (GCD(i, j) == 1) {
                        if (i + j < sum) {
                            sum = i + j;
                            a = i;
                            b = j;
                        } else
                            break;
                    }
                }
            }
            if (a < b)
                System.out.println(a * g + " " + b * g);
            else
                System.out.println(b * g + " " + a * g);
        }
    }
}