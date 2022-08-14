using System.Collections;
using System.Collections.Generic;
using static System.Console;
using System;

class Program
{
    public static void Main()
    {
        bool[] check = new bool[1001];
        ArrayList[] arr_list = new ArrayList[1001];
        for (int i = 0; i < 1001; i++) arr_list[i] = new ArrayList();

        string[] s = ReadLine().Split(' ');
        int n = int.Parse(s[0]);
        int m = int.Parse(s[1]);
        int count = 0;

        while (m-- > 0)
        {
            s = ReadLine().Split(' ');
            int a = int.Parse(s[0]);
            int b = int.Parse(s[1]);
            arr_list[a].Add(b);
            arr_list[b].Add(a);
        }
        for (int i = 1; i <= n; i++)
        {
            if (check[i] == false)
            {
                check[i] = true;
                count++;
                DFS(i);
            }
        }

        void DFS(int n)
        {
            foreach (int i in arr_list[n])
            {
                if (check[i] == false)
                {
                    check[i] = true;
                    DFS(i);
                }
            }
        }

        WriteLine(count);
    }
}