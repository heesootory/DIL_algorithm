using System;
using static System.Console;

class Program
{
    public static void Main(string[] args)
    {
        int[] arr = new int[42];
        int num = 10;
        int a = 0;
        while (num-- > 0)
        {
            a = int.Parse(ReadLine());
            arr[a % 42]++;
        }

        int cnt = 0;
        for (int i = 0; i < arr.Length; i++)
        {
            if (arr[i] > 0) cnt++;
        }

        WriteLine(cnt);
    }
}
