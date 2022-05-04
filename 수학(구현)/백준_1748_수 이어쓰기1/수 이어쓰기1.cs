using System.Collections;
using static System.Console;
using System;

class Program
{
    public static void Main()
    {
        string[] s = ReadLine().Split(' ');
        int N = int.Parse(s[0]);

        long sum = 0;
        int m = 9;
        int ten_mul = 10;
        int i = 1;
        int norm = m;

        while (N > norm)
        {
            N -= norm;
            sum += (norm * i);
            i++;
            norm = m * (int)Math.Pow(ten_mul, i - 1);
            // Math.Pow는 반환형이 double임. -> 명시적 형변환 필요
        }
        sum += (N * i);
        WriteLine(sum);


    }
}