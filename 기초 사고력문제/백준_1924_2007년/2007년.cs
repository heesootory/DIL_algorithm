using System;
using System.Diagnostics.CodeAnalysis;
using static System.Console;

class Program
{
   
    public static void Main(string[] args)
    {
        int[] month = new int[13]
            {0, 31, 28, 31 ,30 ,31, 30, 31, 31, 30, 31, 30, 31 };

        string[] week = new string[7]
            {"MON", "TUE", "WED", "THU", "FRI", "SAT", "SUN" };

        string[] s = ReadLine().Split();
        int m = int.Parse(s[0]);
        int d = int.Parse(s[1]);

        int sum = 0;

        for (int i = m - 1; i > 0; i--) sum += month[i];
        sum += (d - 1);
        Write(week[sum % 7]);
        
    }
}
