using System.Text;
using static System.Console;

class Program
{
    static int min = 1000000;
    static void dp(int x, int count)
    {
        if( x <= 1)
        {
            if (count < min) min = count;
            return;
        }
        count++;

        if (count >= min) return;
        if (x % 3 == 0) dp(x / 3, count);
        if (x % 2 == 0) dp(x / 2, count);
        dp(x - 1, count);

        return;
    }
    public static void Main(string[] args)
    {
        int input = int.Parse(ReadLine());
        dp(input, 0);
        WriteLine(min);
    }
}