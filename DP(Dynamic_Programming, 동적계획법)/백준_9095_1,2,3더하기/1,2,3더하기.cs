using System.Text;
using System;
using static System.Console;

class Program
{
    static int[] arr = new int[12];
    public static void Main(string[] args)
    {
        arr[1] = 1;
        arr[2] = 2;
        arr[3] = 4;
        int T = int.Parse(ReadLine());
        for(int i = 0; i< T; i++)
        {
            int n = int.Parse(ReadLine());
            if (arr[n] > 0) WriteLine(arr[n]);
            else
            {
                for(int j = 4; j<= n; j++)
                {
                    arr[j] = arr[j - 1] + arr[j - 2] + arr[j - 3];
                }
                WriteLine(arr[n]);
            }
        }


    }
}