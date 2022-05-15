using System.Collections;
using static System.Console;
using System;

class Program
{
    public static void Main()
    {
        string[] s = ReadLine().Split(' ');
        int N = int.Parse(s[0]);
        int x = 0, y = 0;
        int first_x = 0, first_y = 0;
        int past_x = 0, past_y = 0;
        long sum1 = 0, sum2 = 0;

        for (int i = 0; i < N; i++)
        {
            s = ReadLine().Split(' ');
            x = int.Parse(s[0]);
            y = int.Parse(s[1]);
            if (i == 0)
            {
                first_x = x;
                first_y = y;
            }

            sum1 += ((long)past_x * y);
            sum2 += ((long)past_y * x);
            past_x = x;
            past_y = y;

        }
        sum1 += ((long)past_x * first_y);
        sum2 += ((long)past_y * first_x);
        long max_sum = Math.Max(sum1, sum2);
        long min_sum = Math.Min(sum1, sum2);
        double ans = (double)(max_sum - min_sum) / 2;
        ans = Math.Round(ans * 10) / 10;
        Write("{0:F1}", ans);
    }
}