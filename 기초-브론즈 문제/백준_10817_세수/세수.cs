using System;
using static System.Console;

namespace cs_algo
{
    class Program
    {
        public static void  Main(string[] args)
        {
            int[] arr = new int[3];
            string[] s = ReadLine().Split(' ');
            for (int i = 0; i < 3; i++)
                arr[i] = int.Parse(s[i]);
            Array.Sort(arr,0,3);
            WriteLine(arr[1]);
        }
    }
}