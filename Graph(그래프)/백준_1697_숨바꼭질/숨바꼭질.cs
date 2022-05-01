using System.Collections;
using static System.Console;
using System;

class Program
{
    static int a, b;
    static Queue q = new Queue();
    static ArrayList _move = new ArrayList();
    static bool[] check = new bool[100001];
    static int[] seconds = new int[100001];
    static void BFS(int n)
    {
        q.Enqueue(n);
        check[n] = true;
        while (q.Count != 0)
        {
            int f = (int)q.Dequeue();
            _move.Add(f - 1);
            if (f < b)
            {
                _move.Add(f + 1);
                _move.Add(f * 2);
            }
            foreach (int i in _move)
            {
                if (i >= 0 && i <= 100000)
                {
                    if (check[i] == false)
                    {
                        q.Enqueue(i);
                        check[i] = true;
                        seconds[i] = seconds[f] + 1;
                        if (i == b) return;
                    }
                }
            }
            _move.Clear();
        }
    }

    public static void Main()
    {
        string[] s = ReadLine().Split(' ');
        a = int.Parse(s[0]);
        b = int.Parse(s[1]);

        BFS(a);
        Write(seconds[b]);

    }
}