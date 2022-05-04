import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        Long sick_finger = s.nextLong();
        Long can_count = s.nextLong();

        Long num_count = 0L;

        if (can_count == 0L) {
            for (int i = 1; i < sick_finger; i++)
                num_count++;
        } else {
            if (sick_finger == 1L || sick_finger == 5L) {
                num_count += (4 * 2 * can_count);
                for (int i = 1; i < sick_finger; i++)
                    num_count++;
            } else {
                num_count += (4 * can_count);
                if (can_count % 2 == 0L) {
                    for (int i = 1; i < sick_finger; i++)
                        num_count++;
                } else {
                    for (int i = 5; i > sick_finger; i--)
                        num_count++;
                }
            }
        }
        System.out.println(num_count);
    }
}