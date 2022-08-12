using System;
using static System.Console;

namespace cs_algo
{
    class Program
    {
        public static void  Main(string[] args)
        {
            int min1 = 2000;
            for (int i = 0; i < 3; i++)
            {
                int burger = int.Parse(ReadLine());
                if (burger < min1) min1 = burger;
            }

            int min2 = 2000;
            for (int i = 0; i < 2; i++)
            {
                int drink = int.Parse(ReadLine());
                if (drink < min2) min2 = drink;
            }

            WriteLine(min1 + min2 - 50);


        }
    }
}