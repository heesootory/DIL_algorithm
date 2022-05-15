using System.Collections;
using static System.Console;
using System;

class Program
{
    static int external_product(long a1, long b1, long a2, long b2, long a3, long b3)
    {
        long ans = ((a1 - a2) * (b2 - b3)) - ((a2 - a3) * (b1 - b2));
        if (ans > 0) return 1;
        else if (ans < 0) return -1;
        else return 0;
    }
    public static void Main()
    {
        int x1, y1, x2, y2;
        int x3, y3, x4, y4;

        string[] s = ReadLine().Split(' ');
        x1 = int.Parse(s[0]);
        y1 = int.Parse(s[1]);
        x2 = int.Parse(s[2]);
        y2 = int.Parse(s[3]);
        s = ReadLine().Split(' ');
        x3 = int.Parse(s[0]);
        y3 = int.Parse(s[1]);
        x4 = int.Parse(s[2]);
        y4 = int.Parse(s[3]);

        int a = external_product(x1, y1, x2, y2, x3, y3);
        int b = external_product(x1, y1, x2, y2, x4, y4);
        int c = external_product(x3, y3, x4, y4, x1, y1);
        int d = external_product(x3, y3, x4, y4, x2, y2);

        if (a * b <= 0 && c * d <= 0) Write("1");
        else Write("0");
    }
}