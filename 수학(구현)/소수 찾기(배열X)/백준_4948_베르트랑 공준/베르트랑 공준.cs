using System.Collections;
using static System.Console;
using System;

class Program
{
    static bool is_prime(int n)
    {
        for (int i = 2; i * i <= n; i++)
        {
            if (n % i == 0) return false;
        }
        return true;
    }

    public static void Main()
    {
        int n;
        int s;
        while (true)
        {
            s = int.Parse(ReadLine());
            if (s == 0) break;

            int count = 0;
            for (int i = s + 1; i <= 2 * s; i++)
            {
                if (is_prime(i)) count++;
            }
            WriteLine(count);
        }


    }
}