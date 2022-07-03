using System;
using static System.Console;

class Program
{
    public static char[][] arr = new char[200][];
    public static void set(int n, int r, int idx)
    {
        int row = 2 * n - 1;
        int col = 4 * n - 3;

        for (int i = 0; i < col - idx + 1; i++) arr[r][i] = ' ';

        if (r == 0 || r == row - 1)
        {
            for (int i = 0; i < n; i++) arr[r][i] = '*';
            for (int i = col - n; i < col; i++) arr[r][i] = '*';
        }
        else
        {
            for (int i = idx; i < idx + 1; i++) arr[r][i] = '*';
            for (int i = idx + n - 1; i < idx + n; i++) arr[r][i] = '*';
            for (int i = col - idx - 1; i < col - idx; i++) arr[r][i] = '*';
            for (int i = col - idx - n; i < col - idx - n + 1; i++) arr[r][i] = '*';
        }
        
        for(int i = 0; i< col - idx + 1; i++) Write($"{arr[r][i]}");
    }
    public static void Main(string[] args)
    {
        for (int i = 0; i < arr.Length; i++) arr[i] = nsew char[400];
        int n = int.Parse(ReadLine());
        int idx = 0;
        
        for (int i = 0; i < 2 * n - 1; i++)
        {
            set(n, i, idx);
            if (i < n - 1) idx++;
            else idx--;
            WriteLine();
        }
    }
}