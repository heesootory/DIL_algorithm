using System;
using static System.Console;

class Program
{
    static int[] count_arr = new int[300000];

    static void DFS(int a, int p)
    {
        double new_a = 0;      //Math.Pow(제곱수 구하는 내장함수) 사용하기 위해선, double 타입으로 받아야 함.

        while (a > 0)
        {    //새로운 수 생성
            int left = a % 10;
            new_a += Math.Pow(left, p);
            a /= 10;
        }
        int x = (int)new_a;    //배열이 int 이므로, 다시 int로 형변환....ㅜ

        count_arr[x]++;
        if (count_arr[x] > 2) return;
        DFS(x, p);
    }

    public static void Main(string[] args)
    {
        string[] s = ReadLine().Split(' ');
        int A = int.Parse(s[0]);
        int P = int.Parse(s[1]);

        count_arr[A]++;
        DFS(A, P);
        int count = 0;
        for (int i = 0; i < count_arr.Length; i++)
            if (count_arr[i] == 1) count++;

        Write($"{count}");


    }
}