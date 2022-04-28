import java.io.*;
import java.util.*;

public class Main {
    static boolean[] check = new boolean[1001];
    static ArrayList<Integer>[] arr_list = new ArrayList[1001];

    static void make_arr(ArrayList<Integer>[] arr_list) {
        for (int i = 0; i < 1001; i++)
            arr_list[i] = new ArrayList();
    }

    static void DFS(int n) {
        for (int i : arr_list[n]) {
            if (check[i] == false) {
                check[i] = true;
                DFS(i);
            }
        }
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int N = s.nextInt();
        int M = s.nextInt();
        make_arr(arr_list);

        int count = 0;
        while (M-- > 0) {
            int a = s.nextInt();
            int b = s.nextInt();

            arr_list[a].add(b);
            arr_list[b].add(a);
        }

        for (int i = 1; i <= N; i++) {
            if (check[i] == false) {
                check[i] = true;
                count++;
                DFS(i);
            }
        }
        System.out.println(count);
    }
}