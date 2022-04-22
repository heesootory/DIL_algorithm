using System.Text;
using System;
using static System.Console;

class Program
{
    static long[] arr = new long[1001];
    public static void Main(string[] args)
    {
        arr[0] = 0; arr[1] = 1; arr[2] = 3;

        int n = int.Parse(ReadLine());
        for( int i = 3; i<=n; i++)
        {
            arr[i] = arr[i - 1] * 2;
            if (i % 2 == 0) arr[i] += 1;
            else arr[i] -= 1;
            arr[i] = arr[i] %= 10007;
        }
        Write(arr[n]);

    }
}