using System.Text;
using System;
using static System.Console;

class Program
{
    static long[] arr = new long[1001];
    public static void Main(string[] args)
    {
        arr[0] = 0; arr[1] = 1; arr[2] = 2;

        int n = int.Parse(ReadLine());
        for( int i = 3; i<=n; i++)
        {
            arr[i] = (arr[i - 1] + arr[i - 2])%10007;
        }
        Write(arr[n]);

    }
}