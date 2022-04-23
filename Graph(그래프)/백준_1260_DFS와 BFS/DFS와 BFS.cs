using System.Collections;
using System.Collections.Generic;
using static System.Console;
using System;

class Program
{
    static ArrayList[] edge = new ArrayList[1001];
    static bool[] check = new bool[1001];

    static void DFS(int n)
    {
        if (check[n] == true) return;

        check[n] = true;
        Write($"{n} ");
        foreach (int i in edge[n]) DFS(i);
    }

    static void BFS(int n)
    {
        Queue q = new Queue();
        q.Enqueue(n);
        check[n] = true;

        while (q.Count != 0)
        {
            int f = (int)q.Dequeue();
            Write($"{f} ");
            foreach (int i in edge[f])
            {
                if (check[i] == false)
                {
                    q.Enqueue(i);
                    check[i] = true;
                }
            }
        }
    }

    public static void Main(string[] args)
    {
        for (int i = 0; i < 1001; i++) edge[i] = new ArrayList();

        string[] s = ReadLine().Split(' ');
        int N = int.Parse(s[0]), M = int.Parse(s[1]), v = int.Parse(s[2]);

        while (M-- > 0)
        {
            s = ReadLine().Split(' ');
            int a = int.Parse(s[0]);
            int b = int.Parse(s[1]);
            edge[a].Add(b);
            edge[b].Add(a);
        }

        for (int i = 0; i <= N; i++) edge[i].Sort();
        DFS(v);
        for (int i = 0; i <= N; i++) check[i] = false;
        Write("\n");
        BFS(v);


    }
}