using System;
using static System.Console;

class Program
{
    public static void Main(string[] args)
    {
        int n = int.Parse(ReadLine());
        while (n-- > 0)
        {
            string[] s = ReadLine().Split();
            int m = int.Parse(s[0]);
            int[] arr = new int[m];
            int ever = 0;
            for (int i = 0; i < m; i++)
            {
                arr[i] = int.Parse(s[i+1]);
                ever += arr[i];
            }
            ever /= m;
            int cnt = 0;
            for (int i = 0; i < arr.Length; i++)
                if (arr[i] > ever) cnt++;
            
            WriteLine("{0:F3}%", ((float)cnt*100/m));
        }
        
    }
}
