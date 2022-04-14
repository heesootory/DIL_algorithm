using System.Text;
using static System.Console;

class Program
{
    static int[] mx = new int[4] { 0, 1, 0, -1 };
    static int[] my = new int[4] { 1, 0, -1, 0 };


    public static void Main(string[] args)
    {
        StringBuilder md = new StringBuilder();     //출력 속도 올리기 위해 사용 - md 객체에 버퍼에 들어오는 것 저장 
        int ROW = 500;
        int COL = 500;

        char[][] medow = new char[ROW][];
        for (int m = 0; m < ROW; m++)
            medow[m] = new char[COL];

        // 행, 열 입력
        string[] s = ReadLine().Split(' ');
        int R = int.Parse(s[0]);
        int C = int.Parse(s[1]);
        bool defense = true;

        // 초기 배열 받기 -> 문자열을 받아와서 한 글자씩 배열에 대입.
        for (int i = 0; i < R; i++)
        {
            string str = ReadLine();
            for(int j = 0; j< C; j++)
            {
                medow[i][j] = str[j];
            }
        }

        for(int i = 0; i< R; i++)
        {
            for(int j = 0; j< C; j++)
            {
                if(medow[i][j] == 'W')
                {
                    for (int a = 0, b = 0; a < 4; a++, b++)
                    {       //양 주위 시계 방향으로 조사
                        int new_i = i + mx[a];
                        int new_j = j + my[b];
                        if (new_i < 0 || new_j < 0 || new_i > R - 1 || new_j > C - 1) continue;         //범위 배열 넘을시.

                        if (medow[new_i][new_j] == 'S')
                        {
                            defense = false; break;
                        }
                        else if (medow[new_i][new_j] == 'W' || medow[new_i][new_j] == 'D') continue;
                        else medow[new_i][new_j] = 'D';
                    }
                }
            }
        }

        //* 출력 *//
        if (defense)
        {
            md.Append("1\n");
            for (int i = 0; i < R; i++)
            {
                for (int j = 0; j < C; j++)
                {
                    md.Append(medow[i][j]);     //md 객체에 저장
                }
                md.Append("\n");
            }
        }
        else md.Append("0\n");

        Write(md);  //md객체에 저장된 버퍼 출력
    }
}