using System;
using System.Text;
using static System.Console;

class Program
{
    public static void Main(string[] args)
    {
        StringBuilder ans = new StringBuilder();
        int n = int.Parse(ReadLine());
        int m = int.Parse(ReadLine());
        
        int[][] arr = new int[1000][];
        for (int r = 0; r < arr.Length; r++) arr[r] = new int[1000];
        int k = 1;
        int i = n / 2;
        int j = n / 2;
        int num = 1;

        arr[i][j] = num;
        while (k <= n)
        {
            if (k == n)
            {
                for (int l = 0; l < k - 1; l++)
                {
                    i--;
                    num++;
                    arr[i][j] = num;
                }
            }
            else if (k % 2 != 0)
            {
                for (int r = 0; r < k; r++)
                {
                    i--;
                    num++;
                    arr[i][j] = num;
                }

                for (int r = 0; r < k; r++)
                {
                    j++;
                    num++;
                    arr[i][j] = num;
                }
            }
            else
            {
                for (int r = 0; r < k; r++)
                {
                    i++;
                    num++;
                    arr[i][j] = num;
                }

                for (int r = 0; r < k; r++)
                {
                    j--;
                    num++;
                    arr[i][j] = num;
                }
            }

            k++;
        }
        int ans_i = 0;
        int ans_j = 0;
        for(int a = 0; a < n; a++)
        {
            for (int b = 0; b < n; b++)
            {
                ans.Append(arr[a][b] + " ");
                if (arr[a][b] == m)
                {
                    ans_i = a;
                    ans_j = b;
                }
            }

            ans.Append("\n");
        }

        ans.Append((ans_i+1) + " " + (ans_j+1));
        Write(ans.ToString());
    }
}