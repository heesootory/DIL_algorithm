using System;
using static System.Console;

class Program
{
    public static void Main(string[] args)
    {
        int n = int.Parse(ReadLine());
        int[] arr = new int[10];
        int i = 0;
        while (n >= 1)
        {
            arr[i] = n % 10;
            i++;
            n /= 10;
        }
        Array.Resize(ref arr, i);       //배열 사이즈 변경 Resize(ref 배열명, 크기)
        Array.Sort(arr);
        for(int j = arr.Length-1; j >= 0; j--) Write(arr[j]);
    }
}
