using System.Collections;
using static System.Console;
using System;

class Program
{
    static int GCD(int a, int b)
    {
        int left = 0;
        while (true)
        {
            left = a % b;
            if (left == 0) break;
            a = b;
            b = left;
        }
        return b;
    }
    static int LCD(int a, int b)
    {
        int gcd = GCD(a, b);
        return (a / gcd * b / gcd * gcd);
    }
    public static void Main()
    {
        int _case = int.Parse(ReadLine());
        while (_case-- > 0)
        {
            int M, N, x, y;
            string[] s = ReadLine().Split(' ');
            M = int.Parse(s[0]);
            N = int.Parse(s[1]);
            x = int.Parse(s[2]);
            y = int.Parse(s[3]);

            int i = x;
            bool iss = false;
            int lcd = LCD(M, N);

            if (N == y) y = 0;
            while (i <= lcd)
            {
                if (i % N == y)
                {
                    iss = true; break;
                }
                i += M;
            }
            if (iss) WriteLine(i);
            else WriteLine("-1");
        }
    }
}