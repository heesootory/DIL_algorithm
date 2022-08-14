import java.util.*;

public class Main {
    static int a, b;
    static Queue<Integer> q = new LinkedList();
    static boolean[] check = new boolean[100001];
    static int[] seconds = new int[100001];
    static ArrayList<Integer> _move = new ArrayList();

    static void BFS(int n) {
        q.add(n);
        check[n] = true;
        while (q.isEmpty() == false) {
            int f = q.peek();
            q.poll();
            _move.add(f - 1);
            if (f < b) {
                _move.add(f + 1);
                _move.add(f * 2);
            }
            for (int i : _move) {
                if (i >= 0 && i <= 100000) {
                    if (check[i] == false) {
                        check[i] = true;
                        q.add(i);
                        seconds[i] = seconds[f] + 1;
                        if (i == b)
                            return;
                    }
                }
            }
            _move.clear();
        }
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        a = s.nextInt();
        b = s.nextInt();

        BFS(a);

        System.out.println(seconds[b]);

    }
}