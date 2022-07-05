using System;
using System.Text;
using static System.Console;

class Program
{
    public static void Main(string[] args)
    {
        int n = int.Parse(ReadLine());
        int past_hour = 0;
        int past_min = 0;
        int hour = 0;
        int min = 0;
        int team = 0;
        int team1_score = 0;
        int team2_score = 0;
        int team1_min = 0;
        int team2_min = 0;

        while(n-- > 0)
        {
            string[] s = ReadLine().Split(' ', ':');
            team = int.Parse(s[0]);
            hour = int.Parse(s[1]);
            min = int.Parse(s[2]);
            int win_time = (hour - past_hour) * 60 + (min - past_min);  //분으로 정리
            if(team1_score > team2_score) team1_min += win_time;
            else if(team1_score < team2_score) team2_min += win_time;
            past_hour = hour;
            past_min = min;

            if(team == 1) team1_score++;
            else team2_score++;
        }
        int final_time = (48 - past_hour) * 60 - past_min;
        if(team1_score > team2_score) team1_min += final_time;
        else if(team1_score < team2_score) team2_min += final_time;

        Write("{0:D2}:{1:D2}\n{2:D2}:{3:D2}", team1_min/60, team1_min%60, team2_min/60,  team2_min%60 );
    }
}