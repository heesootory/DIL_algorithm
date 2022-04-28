using System.Collections;
using System.Collections.Generic;
using static System.Console;
using System.Text;      //StringBuilder
using System;

class Program
{
    static Queue q = new Queue();
    static bool[] check = new bool[100001];
    static int[] parent_node = new int[100001];
    static ArrayList[] edge = new ArrayList[100001];
    static void makeArrayList(ArrayList[] arr_list)
    {
        for (int i = 0; i < arr_list.Length; i++) arr_list[i] = new ArrayList();
    }

    static void BFS(int n)
    {
        q.Enqueue(n);
        check[n] = true;

        while (q.Count != 0)
        {
            int f = (int)q.Dequeue();
            foreach (int i in edge[f])
            {
                if (check[i] == false)
                {
                    check[i] = true;
                    q.Enqueue(i);
                    parent_node[i] = f;
                }
            }
        }
    }
    public static void Main()
    {
        StringBuilder sb = new StringBuilder();     //출력시간 단축
        string[] s = ReadLine().Split();
        makeArrayList(edge);
        int N = int.Parse(s[0]);
        int M = N - 1;
        while (M-- > 0)
        {
            int a, b;
            s = ReadLine().Split(' ');
            a = int.Parse(s[0]); b = int.Parse(s[1]);
            edge[a].Add(b);
            edge[b].Add(a);
        }

        BFS(1);

        for (int i = 2; i <= N; i++)
        {
            sb.Append(parent_node[i] + "\n");
        }
        WriteLine(sb);
    }
}