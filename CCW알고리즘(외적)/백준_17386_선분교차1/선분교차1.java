import java.util.*;

public class Main {

    static int external_product(long a1, long b1, long a2, long b2, long a3, long b3) {
        long ans = ((a1 - a2) * (b2 - b3)) - ((a2 - a3) * (b1 - b2));
        if (ans > 0)
            return 1;
        else if (ans < 0)
            return -1;
        else
            return 0;
    }

    public static void main(String[] args) {

        int x1, y1, x2, y2;
        int x3, y3, x4, y4;

        Scanner s = new Scanner(System.in);
        x1 = s.nextInt();
        y1 = s.nextInt();
        x2 = s.nextInt();
        y2 = s.nextInt();
        x3 = s.nextInt();
        y3 = s.nextInt();
        x4 = s.nextInt();
        y4 = s.nextInt();

        int a = external_product(x1, y1, x2, y2, x3, y3);
        int b = external_product(x1, y1, x2, y2, x4, y4);
        int c = external_product(x3, y3, x4, y4, x1, y1);
        int d = external_product(x3, y3, x4, y4, x2, y2);

        if (a * b <= 0 && c * d <= 0)
            System.out.println("1");
        else
            System.out.println("0");

    }
}