using System;
using static System.Console;

namespace cs_algo
{
    class Program
    {
        public static void  Main(string[] args)
        {
            int n, p;
            string[] s = ReadLine().Split(' ');
            n = int.Parse(s[0]);
            p = int.Parse(s[1]);
            int[] arr = new int[1001];
            int m = n;
            int cnt = 0;

            while (true)
            {
                int i = (n * m) % p;
                if (arr[i] > 2) break;
                arr[i]++;
                m = i;
            }
            for(int i =0 ; i<arr.Length; i++)
                if (arr[i] > 1)
                    cnt++;
            
            WriteLine(cnt);
        }
    }
}