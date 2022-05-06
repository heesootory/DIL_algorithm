using System.Collections;
using static System.Console;
using System;

class Program
{
    public static void Main()
    {
        int L, R;
        string[] s = ReadLine().Split(' ');
        L = int.Parse(s[0]);
        R = int.Parse(s[1]);

        int min_cnt = 10;
        for (int i = L; i <= R; i++)
        {
            int n = i;
            int cnt = 0;
            while (n > 0)
            {
                if (n % 10 == 8) cnt++;
                n /= 10;
            }
            if (cnt < min_cnt) min_cnt = cnt;
            if (min_cnt == 0) break;
        }
        Write(min_cnt);
    }
}