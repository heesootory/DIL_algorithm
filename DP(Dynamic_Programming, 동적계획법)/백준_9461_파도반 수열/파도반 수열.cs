using System.Text;
using System;
using static System.Console;

class Program
{
    static long[] arr = new long[101];
    public static void Main(string[] args)
    {
        arr[1] = 1; arr[2] = 1; arr[3] = 1; arr[4] = 2; arr[5] = 2;

        int T = int.Parse(ReadLine());
        for(int i = 0; i< T; i++)
        {
            int n = int.Parse(ReadLine());
            if (n < 6) WriteLine(arr[n]);
            else
            {
                for(int j = 6; j<= n; j++)
                {
                    arr[j] = arr[j - 1] + arr[j - 5];
                }
                WriteLine(arr[n]);
            }
        }

    }
}