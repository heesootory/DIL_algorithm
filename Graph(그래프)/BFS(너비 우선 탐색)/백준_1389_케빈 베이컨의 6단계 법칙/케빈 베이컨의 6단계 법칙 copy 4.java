import java.util.*;

public class Main {
    static int n, m;
    static ArrayList<Integer>[] user = new ArrayList[101];
    static boolean[] check = new boolean[101];
    static int[] friends = new int[101];
    static Queue<Integer> q = new LinkedList();
    static int min_count = 101;

    static void BFS(int n) {
        q.add(n);
        check[n] = true;
        while (q.isEmpty() == false) {
            int f = q.peek();
            q.poll();
            for (int i : user[f]) {
                if (check[i] == false) {
                    check[i] = true;
                    friends[i] = friends[f] + 1;
                    q.add(i);
                }
            }
        }
    }

    static int friends_init_sum() {
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += friends[i];
            friends[i] = 0;
        }
        return sum;
    }

    static void check_init() {
        for (int i = 1; i <= n; i++)
            check[i] = false;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 101; i++)
            user[i] = new ArrayList();
        Scanner s = new Scanner(System.in);
        n = s.nextInt();
        m = s.nextInt();
        while (m-- > 0) {
            int a = s.nextInt();
            int b = s.nextInt();
            user[a].add(b);
            user[b].add(a);
        }
        int min_who = 0;
        for (int i = 1; i <= n; i++) {
            BFS(i);
            check_init();
            int fri_sum = friends_init_sum();
            if (fri_sum < min_count) {
                min_count = fri_sum;
                min_who = i;
            }
        }
        System.out.println(min_who);
    }
}