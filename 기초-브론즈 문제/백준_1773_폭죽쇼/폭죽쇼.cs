using System;
using static System.Console;

namespace cs_algo
{
    class Program
    {
        public static void  Main(string[] args)
        {
            int n, c;
            int[] time = new int[101];
            bool[] fire = new bool[2000001];
            string[] s = ReadLine().Split(' ');
            n = int.Parse(s[0]);
            c = int.Parse(s[1]);
            for (int i = 0; i < n; i++)
                time[i] = int.Parse(ReadLine());

            int cnt = 0;
            for (int i = 0; i < n; i++)
            {
                for (int j = time[i]; j <= c; j += time[i])
                {
                    if (fire[j]) continue;
                    fire[j] = true;
                    cnt++;
                }
            }
            WriteLine(cnt);
        }
    }
}


