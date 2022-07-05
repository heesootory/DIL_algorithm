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
        int b = 0;
        while (n-- > 0)
        {
            string[] s = ReadLine().Split(' ');
            if (s[0] == "push")
            {
                int num = int.Parse(s[1]);
                arr[b] = num;
                b++;
            }
            else if (s[0] == "pop")
            {
                if (f == b) ans.Append(-1 + "\n");
                else
                {
                    ans.Append(arr[f] + "\n");
                    arr[f] = 0;
                    f++;
                }
            }
            else if (s[0] == "size") ans.Append(b-f + "\n");
            else if (s[0] == "empty")
            {
                if(f == b) ans.Append(1 + "\n");
                else ans.Append(0 + "\n");
            }
            else if (s[0] == "front")
            {
                if(f == b) ans.Append(-1 + "\n");
                else ans.Append(arr[f] + "\n");
            }
            else if (s[0] == "back")
            {
                if(f == b) ans.Append(-1 + "\n");
                else ans.Append(arr[b-1] + "\n");
            }
        }
        WriteLine(ans.ToString());
    }
}