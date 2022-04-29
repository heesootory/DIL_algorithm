using System.Collections;
using static System.Console;
using System;

class Program
{
    static int n, m;
    static int max_cnt;
    static Queue q = new Queue();
    static int[][] sea = new int[51][];
    static int[] mx = new int[8] { -1, -1, -1, 0, 1, 1, 1, 0 };
    static int[] my = new int[8] { -1, 0, 1, 1, 1, 0, -1, -1 };
    public class shark
    {
        public int x;
        public int y;
        public shark(int x, int y)
        {
            this.x = x;
            this.y = y;
        }
    }

    static void BFS()
    {
        while (q.Count != 0)
        {
            shark sh = (shark)q.Dequeue();
            int sx = sh.x;
            int sy = sh.y;
            for (int i = 0; i < 8; i++)
            {
                int new_x = sx + mx[i];
                int new_y = sy + my[i];
                if (new_x >= 0 && new_x < n && new_y >= 0 && new_y < m)
                {
                    if (sea[new_x][new_y] == 0)
                    {
                        sea[new_x][new_y] = sea[sx][sy] + 1;
                        shark shark_possible = new shark(new_x, new_y);
                        q.Enqueue(shark_possible);
                        if (sea[new_x][new_y] > max_cnt)
                            max_cnt = sea[new_x][new_y];
                    }
                }
            }
        }
    }
    public static void Main()
    {
        for (int i = 0; i < sea.Length; i++) sea[i] = new int[51];
        string[] s = ReadLine().Split(' ');
        n = int.Parse(s[0]);
        m = int.Parse(s[1]);

        for (int i = 0; i < n; i++)
        {
            s = ReadLine().Split(' ');
            for (int j = 0; j < m; j++)
            {
                sea[i][j] = int.Parse(s[j]);
                shark shark_position = new shark(i, j);
                if (sea[i][j] == 1)
                    q.Enqueue(shark_position);
            }
        }

        BFS();
        Write(max_cnt - 1);
    }
}
