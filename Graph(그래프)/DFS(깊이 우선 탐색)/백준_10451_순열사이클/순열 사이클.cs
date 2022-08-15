using System.Collections;
using System.Collections.Generic;
using static System.Console;
using System;

class Program
{
    static int[] arr = new int[1001];
    static bool[] check = new bool[1001];

    static int cycle(int n)
    {
        int count = 0;
        for (int i = 1; i <= n; i++)
        {
            if (check[i] == false)
            {
                count++;
                int start = i;
                int end = arr[i];
                while (start != end)
                {
                    check[end] = true;
                    end = arr[end];
                }
            }
        }
        return count;
    }
	public static void Main(string[] args)
    {
        int T = 0;
        T = int.Parse(ReadLine());
        int n = 0;
        while (T-- > 0)
        {
            n = int.Parse(ReadLine());
            string[] s = ReadLine().Split(' ');
            for(int i = 1; i<=n; i++)
            {
                arr[i] = int.Parse(s[i-1]);
                check[i] = false;
            }

            WriteLine(cycle(n));
        }
    }
}