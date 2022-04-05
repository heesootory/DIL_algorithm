using System;
using System.Text;

namespace c3_Ex2
{
    class Program
    {
        static int max_count(int max)
        {
            int count = 0;
            while(max > 0)
            {
                max /= 10;
                count++;
            }
            return count;
        }
        static void info(int[][] view, int l)
        {   
            for(int i = 0; i<view.Length; i++)
            {
                for(int j = 0; j < view[i].Length; j++)
                {
                    string str = view[i][j].ToString();
                    Console.Write(str.PadLeft(l, ' ') + " ");
                }
                Console.WriteLine();
            }
        }
        static bool Check(int r1, int c1, int r2, int c2, int i, int j, int num, ref int max, ref int[][] view)
        {
            if ((r1 <= i && i <= r2) && (c1 <= j && j <= c2))
            {
                view[i - r1][j - c1] = num;
                //Console.WriteLine("{0},{1} : {2}", i,j,num);
                if (num > max) max = num;
                return true;
            }
            else return false;
        }
        enum Way
        {
            right, up, left, down
        }
        static void Main(string[] args)
        {
            string[] s = Console.ReadLine().Split(' ');
            int r1 = int.Parse(s[0]);
            int c1 = int.Parse(s[1]);
            int r2 = int.Parse(s[2]);
            int c2 = int.Parse(s[3]);

            int row = r2 - r1 + 1;
            int col = c2 - c1 + 1;
            int[][] view = new int[row][];
            for (int x = 0; x < row; x++)
                view[x] = new int[col];

            int count = (row) * (col);
            int num = 1;
            int i = 0, j = 0;
            int odd = 1;
            int even = 2;
            int max = 1;
            if (Check(r1, c1, r2, c2, i, j, num, ref max, ref view))
                count--;
            while (count > 0)
            {
                
                for (int way = 0; way < 4; way++)
                {
                    switch (way)
                    {
                        case (int)Way.right:
                            for(int k = 0; k < odd; k++)
                            {
                                //Console.WriteLine("{0},{1} : {2}", i, j, count);
                                num++; j++;
                                if (Check(r1, c1, r2, c2, i, j, num, ref max, ref view))
                                    count--;
                            }
                            break;
                        case (int)Way.up:
                            for (int k = 0; k < odd; k++)
                            {
                                //Console.WriteLine("{0},{1} : {2}", i, j, count);
                                num++; i--;
                                if (Check(r1, c1, r2, c2, i, j, num, ref max, ref view))
                                    count--;
                            }
                            break;
                        case (int)Way.left:
                            for (int k = 0; k < even; k++)
                            {
                                //Console.WriteLine("{0},{1} : {2}", i, j, count);
                                num++; j--;
                                if (Check(r1, c1, r2, c2, i, j, num, ref max, ref view))
                                    count--;
                            }
                            break;
                        case (int)Way.down:
                            for (int k = 0; k < even; k++)
                            {
                                //Console.WriteLine("{0},{1} : {2}", i, j, count);
                                num++; i++;
                                if (Check(r1, c1, r2, c2, i, j, num, ref max, ref view))
                                    count--;
                            }
                            break;
                    }
                    //Console.WriteLine("count is : {0}", count);
                }
                odd += 2; even += 2;
            }
            info(view, max_count(max));
            //Console.Write(ans.ToString());
            

        }
    }
}
