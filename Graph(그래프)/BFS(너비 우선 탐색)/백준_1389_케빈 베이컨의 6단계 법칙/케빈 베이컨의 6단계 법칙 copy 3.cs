using System.Collections;
using static System.Console;
using System;

class Program
{
    static int n, m;
    static ArrayList[] user = new ArrayList[101];
    static int[] friends = new int[101];
    static bool[] check = new bool[101];
    static Queue q = new Queue();
    static int min_count = 101;

    static void BFS(int n)
    {
        q.Enqueue(n);
        check[n] = true;

        while (q.Count != 0)
        {
            int f = (int)q.Dequeue();
            foreach (int i in user[f])
            {
                if (check[i] == false)
                {
                    check[i] = true;
                    friends[i] = friends[f] + 1;
                    q.Enqueue(i);
                }
            }
        }
    }

    static int friends_init_sum()
    {
        int sum = 0;
        for (int i = 1; i <= n; i++)
        {
            sum += friends[i];
            friends[i] = 0;
        }
        return sum;
    }

    static void check_init()
    {
        for (int i = 1; i <= n; i++) check[i] = false;
    }

    public static void Main()
    {
        for (int i = 0; i < 101; i++) user[i] = new ArrayList();
        string[] s = ReadLine().Split(' ');
        n = int.Parse(s[0]); m = int.Parse(s[1]);
        while (m-- > 0)
        {
            int a, b;
            s = ReadLine().Split();
            a = int.Parse(s[0]); b = int.Parse(s[1]);
            user[a].Add(b); user[b].Add(a);
        }
        int min_who = 0;
        for (int i = 1; i <= n; i++)
        {
            BFS(i);
            check_init();
            int sum_friends = friends_init_sum();
            if (sum_friends < min_count)
            {
                min_count = sum_friends;
                min_who = i;
            }
        }
        Write(min_who);
    }
}