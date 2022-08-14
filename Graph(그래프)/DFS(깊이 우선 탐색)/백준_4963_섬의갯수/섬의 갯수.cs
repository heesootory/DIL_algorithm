using System.Collections;
using System.Collections.Generic;
using static System.Console;
using System;

class Program
{
    static bool[][] arr = new bool[52][];		//초기화가 true, false로	
	static void DFS(int i, int j)
	{
		if (arr[i][j] == false) return;

		arr[i][j] = false;
		DFS(i + 1, j);
		DFS(i + 1, j - 1);
		DFS(i + 1, j + 1);
		DFS(i, j - 1);
		DFS(i, j + 1);
		DFS(i - 1, j);
		DFS(i - 1, j - 1);
		DFS(i - 1, j + 1);
	}
	public static void Main(string[] args)
    {
		int w, h;
		for(int i = 0; i< arr.Length; i++)
			arr[i] = new bool[52];

		while (true)
        {
			string[] input = ReadLine().Split(' ');
			w = int.Parse(input[0]);
			h = int.Parse(input[1]);
			if (w == 0 && h == 0) break;
			int count = 0;
			for(int i = 1; i<=h; i++)
            {
				input = ReadLine().Split(' ');
				for(int j = 1; j<=w; j++)
                {
					if (int.Parse(input[j - 1]) == 1) arr[i][j] = true;
					else arr[i][j] = false;
                }
            }

			for(int i = 1; i<=h; i++)
            {
				for(int j = 1; j<= w; j++)
                {
                    if (arr[i][j]) {
						count++;
						DFS(i, j);
					}
                }
            }
			WriteLine(count);
        }
    }
}