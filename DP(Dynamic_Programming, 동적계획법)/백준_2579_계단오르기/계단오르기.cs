using System.Text;
using System;
using static System.Console;

class Program
{
    static int[] stairs = new int[302];
    static int[] sum = new int[302];
    public static void Main(string[] args)
    {
        int n = int.Parse(ReadLine());
        for(int i =1; i <= n; i++)
        {
            stairs[i] = int.Parse(ReadLine());
        }

        sum[1] = stairs[1];
        sum[2] = stairs[1] + stairs[2];
        sum[3] = Math.Max(stairs[1], stairs[2]) + stairs[3];

        for(int i = 4; i <= n; i++)
        {
            sum[i] = Math.Max(sum[i - 3] + stairs[i - 1], sum[i - 2]) + stairs[i];
        }
        Write(sum[n]);
    }
}