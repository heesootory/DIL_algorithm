import java.io.*;
import java.util.*;

public class Main {
    static Queue<Integer> q = new LinkedList();
    static boolean[] check = new boolean[100001];
    static int[] parent_node = new int[100001];
    static ArrayList<Integer>[] edge = new ArrayList[100001];

    static void makeArrayList(ArrayList<Integer>[] arr_list) {
        for (int i = 0; i < arr_list.length; i++)
            arr_list[i] = new ArrayList();
    }

    static void BFS(int n) {
        q.add(n);
        check[n] = true;

        while (q.isEmpty() == false) {
            int f = q.peek();
            q.poll();
            for (int i : edge[f]) {
                if (check[i] == false) {
                    check[i] = true;
                    q.add(i);
                    parent_node[i] = f;
                }
            }
        }
    }

    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        Scanner s = new Scanner(System.in);
        makeArrayList(edge);
        int N = s.nextInt();
        int M = N - 1;
        while (M-- > 0) {
            int a, b;
            a = s.nextInt();
            b = s.nextInt();
            edge[a].add(b);
            edge[b].add(a);
        }

        BFS(1);

        for (int i = 2; i <= N; i++)
            sb.append(parent_node[i] + "\n");

        System.out.println(sb);

    }
}