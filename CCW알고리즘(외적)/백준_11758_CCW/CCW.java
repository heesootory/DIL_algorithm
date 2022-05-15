import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int x1, y1, x2, y2, x3, y3;
        x1 = s.nextInt();
        y1 = s.nextInt();
        x2 = s.nextInt();
        y2 = s.nextInt();
        x3 = s.nextInt();
        y3 = s.nextInt();

        int external = (((x2 - x1) * (y3 - y2)) - ((x3 - x2) * (y2 - y1)));
        if (external > 0)
            System.out.println("1");
        else if (external < 0)
            System.out.println("-1");
        else
            System.out.println("0");
    }
}
