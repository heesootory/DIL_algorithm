using System;
using static System.Console;

class Program
{
        public static void Main(string[] args)
        {
           int[][] apt = new int[15][];
           for (int i = 0; i < apt.Length; i++)
           {
               apt[i] = new int[15];
               for (int j = 1; j < apt[i].Length; j++)
               {
                   if (i == 0) apt[i][j] = j;
                   else if (j == 1) apt[i][j] = j;
                   else apt[i][j] = apt[i - 1][j] + apt[i][j - 1];
               }
           }

           int T = int.Parse(ReadLine());
           while (T-- > 0)
           {
               int k = int.Parse(ReadLine());
               int n = int.Parse(ReadLine());
               WriteLine(apt[k][n]);
           }


        }
}
