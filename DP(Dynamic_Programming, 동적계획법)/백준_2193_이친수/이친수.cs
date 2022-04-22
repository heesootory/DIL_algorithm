using System.Text;
using System;
using static System.Console;

class Program
{
    static long[] arr = new long[91];         //1부터 제곱수 들어갈 행렬
    public static void Main(string[] args)
    {
        int n = int.Parse(ReadLine());
        arr[1] = 1;
        for(int i = 2; i<= n; i++)
        {
            arr[i] = arr[i - 1] + arr[i - 2];
        }

        Write(arr[n]);


    }
}