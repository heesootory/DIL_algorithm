import java.io.*;
import java.util.*;

public class Main {
    static int[] arr = new int[1001];
    static boolean[] check = new boolean[1001];

    static int cycle(int n) {
        int count = 0;
        for (int i = 1; i <= n; i++) {
            if (check[i] == false) {
                count++;
                int start = i;
                int end = arr[i];
                while (start != end) {
                    check[end] = true;
                    end = arr[end];
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int T = s.nextInt();

        while(T-->0) {
            int n = s.nextInt();
            for (int i = 1; i <= n; i++) {
                arr[i] = s.nextInt();
                check[i] = false;
            }
            System.out.println(cycle(n));
        }
    }
}