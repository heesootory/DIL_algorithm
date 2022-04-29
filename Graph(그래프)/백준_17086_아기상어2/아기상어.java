
import java.util.*;

public class Main {
    static int[][] sea = new int[51][51];
    static int[] mx = new int[] { -1, -1, -1, 0, 1, 1, 1, 0 };
    static int[] my = new int[] { -1, 0, 1, 1, 1, 0, -1, -1 };
    static int n, m;
    static int max_cnt;
    static Queue<shark> q = new LinkedList();

    static public class shark {
        public int x;
        public int y;

        public shark(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static void BFS() {
        while (q.isEmpty() == false) {
            shark sh = q.peek();
            q.poll();
            for (int i = 0; i < 8; i++) {
                int new_x = sh.x + mx[i];
                int new_y = sh.y + my[i];
                if (new_x >= 0 && new_x < n && new_y >= 0 && new_y < m) {
                    if (sea[new_x][new_y] == 0) {
                        sea[new_x][new_y] = sea[sh.x][sh.y] + 1;
                        shark sh_possible = new shark(new_x, new_y);
                        q.add(sh_possible);
                        if (sea[new_x][new_y] > max_cnt)
                            max_cnt = sea[new_x][new_y];
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        n = s.nextInt();
        m = s.nextInt();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                sea[i][j] = s.nextInt();
                shark sh_position = new shark(i, j);
                if (sea[i][j] == 1)
                    q.add(sh_position);
            }
        }
        BFS();

        System.out.println(max_cnt - 1);

    }
}