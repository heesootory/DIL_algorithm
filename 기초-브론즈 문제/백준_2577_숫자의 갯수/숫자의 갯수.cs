using System;
using static System.Console;

namespace cs_algo
{
    class Program
    {
        public static void  Main(string[] args)
        {
            int a = int.Parse(ReadLine());
            int b = int.Parse(ReadLine());
            int c = int.Parse(ReadLine());
            int mul = a * b * c;
            int[] arr = new int[10];

            while (mul >= 1)
            {
                int i = mul % 10;
                arr[i]++;
                mul /= 10;
            }

            for (int i = 0; i < arr.Length; i++) WriteLine(arr[i]);
        }
    }
}