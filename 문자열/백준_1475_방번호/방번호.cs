using System;
using static System.Console;

class Program
{
    public static void Main(string[] args)
    {
        int n = int.Parse(ReadLine());
        int[] arr = new int[10];
        while (n >= 1)
        {
            int i = n % 10;
            if (i == 9) i = 6;
            arr[i]++;
            n /= 10;
        }

        arr[6] = (arr[6] % 2 == 0) ? arr[6] / 2 : arr[6] / 2 + 1;
        int max = 0;
        for (int i = 0; i < arr.Length; i++)
        {
            if (max < arr[i]) max = arr[i];
        }
        WriteLine(max);

    }
}
