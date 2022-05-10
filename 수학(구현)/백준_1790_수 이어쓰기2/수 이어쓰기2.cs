using System.Collections;
using static System.Console;
using System;

class Program
{
    public static void Main()
    {
        long N, k;
        string[] s = ReadLine().Split(' ');
        N = long.Parse(s[0]);
        k = long.Parse(s[1]);

        long norm = 1;
        long norm_cnt = 9;
        long all_cnt = 0;

        while (N > norm_cnt)
        {
            N -= norm_cnt;
            all_cnt += (norm * norm_cnt);
            norm++;
            norm_cnt *= 10;
        }
        all_cnt += (N * norm);

        norm = 1;
        norm_cnt = 9;
        long cnt = 0;

        while (k > cnt + (norm * norm_cnt))
        {
            cnt += (norm * norm_cnt);
            norm++;
            norm_cnt *= 10;
        }

        long cal = k - (cnt + 1);
        long quotient = cal / norm;
        long remainder = cal % norm;
        long i = norm - remainder;
        long num = (long)Math.Pow(10, norm - 1) + quotient;

        long ans = 0;
        while (i-- > 0)
        {
            ans = num % 10;
            num /= 10;
        }
        if (k > all_cnt) Write("-1");
        else Write(ans);
    }
}