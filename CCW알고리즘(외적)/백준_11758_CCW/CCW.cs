using System.Collections;
using static System.Console;
using System;

class Program
{

    public static void Main()
    {
        string[] s = ReadLine().Split(' ');
        int x1, y1, x2, y2, x3, y3;
        x1 = int.Parse(s[0]);
        y1 = int.Parse(s[1]);
        s = ReadLine().Split(' ');
        x2 = int.Parse(s[0]);
        y2 = int.Parse(s[1]);
        s = ReadLine().Split(' ');
        x3 = int.Parse(s[0]);
        y3 = int.Parse(s[1]);

        int external = (((x2 - x1) * (y3 - y2)) - ((x3 - x2) * (y2 - y1)));
        if (external > 0) Write("1");
        else if (external < 0) Write("-1");
        else Write("0");

    }
}