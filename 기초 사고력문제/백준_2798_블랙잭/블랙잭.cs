using System;
using static System.Console;

class Program
{
    public static void Main(string[] args)
    {
        int n, m;
        int[] arr = new int[100];
        string[] s = ReadLine().Split(' ');
        n = int.Parse(s[0]);
        m = int.Parse(s[1]);

        string[] nums = ReadLine().Split(' ');
        for (int i = 0; i < n; i++) arr[i] = int.Parse(nums[i]);

            int max = 0;
        for(int i = 0; i < n-2; i++)
        {
            for (int j = i + 1; j < n - 1; j++)
            {
                for (int k = j + 1; k < n; k++)
                {
                    int sum = arr[i] + arr[j] + arr[k];
                    if (sum <= m)
                    {
                        if (max < sum) max = sum;
                    }
                }
            }
        }

        WriteLine(max);
    }
}
