using System.Collections;
using static System.Console;
using System;

class Program
{
    static double mid_height(double x, double y, double m)
    {
        double h1 = Math.Sqrt(Math.Pow(x, 2) - Math.Pow(m, 2));
        double h2 = Math.Sqrt(Math.Pow(y, 2) - Math.Pow(m, 2));
        return (h1 * h2) / (h1 + h2);
    }
    public static void Main()
    {
        string[] s = ReadLine().Split(' ');
        double x, y, c;
        x = double.Parse(s[0]);
        y = double.Parse(s[1]);
        c = double.Parse(s[2]);
        double max_len = Math.Min(x, y);
        double min_len = 0;
        double mid = 0;

        while (max_len - min_len > 0.000001)
        {
            mid = (max_len + min_len) / 2.0;
            double result = mid_height(x, y, mid);
            if (c <= result) min_len = mid;
            else max_len = mid;
        }

        Write("{0:F3}", mid);
    }
}