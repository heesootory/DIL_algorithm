using System.Collections;
using static System.Console;
using System;

class Program
{
    
    public static void Main()
    {
        string[] s = ReadLine().Split(' ');
        int n = int.Parse(s[0]);
        long start, end;
        long term = 0;

        while(n-- > 0)
        {
            s = ReadLine().Split(' ');
            start = int.Parse(s[0]);
            end = int.Parse(s[1]);
            term = end - start;

            if (term == 1) WriteLine("1");
            else if (term == 2) WriteLine("2");
            else
            {
                long num1 = 2;
                long num_plus = 1;
                long num2 = 3;
                long cnt = 2;

                while (true)
                {
                    cnt++;
                    num1 += num_plus;
                    num_plus++;
                    num2 += num_plus;
                    if (num1 <= term && term < num2) break;

                    cnt++;
                    num1 += num_plus;
                    num2 += num_plus;
                    if (num1 <= term && term < num2) break;
                }
                WriteLine(cnt);
            }
        }
     
    }
}