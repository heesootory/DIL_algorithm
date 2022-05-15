import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        long start, end;
        long term = 0;

        while (n-- > 0) {
            start = s.nextInt();
            end = s.nextInt();
            term = end - start;

            if (term == 1)
                System.out.println("1");
            else if (term == 2)
                System.out.println("2");
            else {
                long num1 = 2;
                long num_plus = 1;
                long num2 = 3;
                long cnt = 2;

                while (true) {
                    cnt++;
                    num1 += num_plus;
                    num_plus++;
                    num2 += num_plus;
                    if (num1 <= term && term < num2)
                        break;

                    cnt++;
                    num1 += num_plus;
                    num2 += num_plus;
                    if (num1 <= term && term < num2)
                        break;
                }
                System.out.println(cnt);
            }
        }
    }
}