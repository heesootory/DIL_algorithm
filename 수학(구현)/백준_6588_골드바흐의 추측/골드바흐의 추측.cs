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
        int a = 0;

        while (true)
        {
            int n = int.Parse(ReadLine());
            if (n == 0) break;

            for (int i = 3; i < n; i += 2)
            {
                if (is_prime(i) && is_prime(n - i))
                {
                    a = i; break;
                }
            }
            if (a == 0) WriteLine("Goldbach's conjecture is wrong.");
            else WriteLine($"{n} = {a} + {n - a}");
        }

    }
}