using System.Collections;
using static System.Console;
using System;

class Program
{
    static int count_zero(int n, int k)
    {
        int cnt = 0;

        for(long i = k; i <= n; i*= k)
        {
            cnt += (int)(n / i);
        }
        return cnt;
    }
    public static void Main()
    {
        int n, m;
        string[] s = ReadLine().Split(' ');
        n = int.Parse(s[0]);
        m = int.Parse(s[1]);

        int f = count_zero(n, 5) - count_zero(m, 5) - count_zero(n - m, 5);
        int t = count_zero(n, 2) - count_zero(m, 2) - count_zero(n - m, 2);
        Write(Math.Min(f, t));

    }
}