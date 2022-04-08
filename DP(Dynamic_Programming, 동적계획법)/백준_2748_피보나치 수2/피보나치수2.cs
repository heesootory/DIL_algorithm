using System;

namespace C_sharp_ex
{
    class Program
    {
        static void Main(string[] args)
        {
            int N = int.Parse(Console.ReadLine());
            long[] d = new long[100];
            d[1] = 1;

            for(int i = 2; i <= N; i++)
                d[i] = d[i - 1] + d[i - 2];

            Console.Write(d[N]);
        }
    }
}
