using System.Text;
using System;
using static System.Console;

class Program
{
    static int[] arr = new int[100000];         //1부터 제곱수 들어갈 행렬
    public static void Main(string[] args)
    {
        int input = int.Parse(ReadLine());
        for(int i = 0; i<= input; i++)
        {
            arr[i] = i;
            for(int j = 0 ; j * j <= i; j++)
            {
                arr[i] = (arr[i] < (arr[i - j * j] + 1)) ? arr[i] : arr[i - j * j] + 1;
            }
        }
        Write(arr[input]);

    }
}