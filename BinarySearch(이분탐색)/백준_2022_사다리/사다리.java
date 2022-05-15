import java.util.*;

public class Main {
    static double mid_height(double x, double y, double m) {
        double h1 = Math.sqrt(Math.pow(x, 2) - Math.pow(m, 2));
        double h2 = Math.sqrt(Math.pow(y, 2) - Math.pow(m, 2));

        return (h1 * h2) / (h1 + h2);
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        double x = s.nextDouble();
        double y = s.nextDouble();
        double c = s.nextDouble();

        double max_len = Math.min(x, y);
        double min_len = 0;
        double mid = 0;

        while (max_len - min_len > 0.000001) {
            mid = (max_len + min_len) / 2.0;
            double result = mid_height(x, y, mid);

            if (c <= result)
                min_len = mid;
            else
                max_len = mid;
        }
        System.out.println(String.format("%.3f", mid));
    }
}