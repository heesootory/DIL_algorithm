using System;
using System.Text;
using static System.Console;

class Program
{
    public static void Main(string[] args)
    {
        StringBuilder ans = new StringBuilder();
        int[] arr = new int[100001];
        int n = int.Parse(ReadLine());
        int f = 0;
        while (n-- > 0)
        {
            string[] s = ReadLine().Split(' ');
            if (s[0] == "push")
            {
                int num = int.Parse(s[1]);
                arr[f] = num;
                f++;
            }
            else if (s[0] == "pop")
            {
                if (f == 0) ans.Append(-1 + "\n");
                else
                {
                    ans.Append(arr[f - 1] + "\n");
                    arr[f - 1] = 0;
                    f--;
                }
            }
            else if (s[0] == "size") ans.Append(f + "\n");
            else if (s[0] == "empty")
            {
                if(f == 0) ans.Append(1 + "\n");
                else ans.Append(0 + "\n");
            }
            else if (s[0] == "top")
            {
                if(f== 0) ans.Append(-1 + "\n");
                else ans.Append(arr[f-1] + "\n");
            }
        }
        WriteLine(ans.ToString());
    }
}