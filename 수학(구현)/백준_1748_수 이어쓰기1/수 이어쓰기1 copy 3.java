import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int N = s.nextInt();

        long sum = 0;
        int m = 9;
        int ten_mul = 10;
        int i = 1;
        int norm = m;

        while (N > norm) {
            N -= norm;
            sum += (norm * i);
            i++;
            norm = m * (int) Math.pow(ten_mul, i - 1);
            // c#과 마찮가지로 pow함수는 return형이 double이므로, 형변환 필요.
        }
        sum += (N * i);
        System.out.println(sum);

    }
}