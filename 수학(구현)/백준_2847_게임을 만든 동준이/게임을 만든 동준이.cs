using System;
using static System.Console;

class Program
{
    public static void Main(string[] args)
    {
        int n = int.Parse(ReadLine());
        int[] arr = new int[100];
        for (int i = 0; i < n; i++) arr[i] = int.Parse(ReadLine());

        int sum = 0;
        for (int i = n - 1; i > 0; i--)
        {
            if (arr[i - 1] >= arr[i])
            {
                sum += (arr[i - 1] - (arr[i] - 1));
                arr[i - 1] = arr[i] - 1;
            }
        }
        WriteLine(sum);
    }
}