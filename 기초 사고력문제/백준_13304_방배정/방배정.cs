using System;
using System.Diagnostics.CodeAnalysis;
using static System.Console;

class Program
{
    public static void room(ref int sum, int stu, int k)
    {
        sum += (stu / k);
        if (stu % k != 0) sum += 1;
    }
    public static void Main(string[] args)
    {
        int n, k;
        int[][] arr = new int[2][];
        for (int i = 0; i < arr.Length; i++) arr[i] = new int[6];

        string[] s = ReadLine().Split();
        n = int.Parse(s[0]);
        k = int.Parse(s[1]);
        int a, b;
        while (n-- > 0)
        {
            string[] ss = ReadLine().Split();
            a = int.Parse(ss[0]);
            b = int.Parse(ss[1]);
            arr[a][b - 1]++;
        }
        
        int smw = arr[0][0] + arr[1][0] + arr[0][1] + arr[1][1];
        int mm = arr[1][2] + arr[1][3];
        int mw = arr[0][2] + arr[0][3];
        int hm = arr[1][4] + arr[1][5];
        int hw = arr[0][4] + arr[0][5];
        int sum = 0;
        room(ref sum, smw, k);
        room(ref sum, mm, k);
        room(ref sum, mw, k);
        room(ref sum, hm, k);
        room(ref sum, hw, k);
        WriteLine(sum);

    }
}
