using System.Collections;
using static System.Console;
using System;

class Program
{
    static int GCD(int a, int b)
    {
        int p = Math.Max(a, b);
        int q = Math.Min(a, b);
        int left = p % q;
        while (left != 0)
        {
            p = q;
            q = left;
            left = p % q;
        }
        return q;
    }
    public static void Main()
    {
        string[] s = ReadLine().Split(' ');
        int g = int.Parse(s[0]);
        int l = int.Parse(s[1]);

        if (g == l) Write("{0} {1}", g, g);
        else
        {
            int p = l / g;
            int sum = p + 2;
            int a = 0, b = 0;

            for (int i = 1; i < p; i++)
            {
                if (p % i == 0)
                {
                    int j = p / i;
                    if (GCD(i, j) == 1)
                    {
                        if (i + j < sum)
                        {
                            sum = i + j;
                            a = i; b = j;
                        }
                        else break;
                    }
                }
            }
            if (a < b) Write("{0} {1}", a * g, b * g);
            else Write("{0} {1}", b * g, a * g);

        }
    }
}