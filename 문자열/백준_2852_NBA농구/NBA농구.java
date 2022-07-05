import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
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
            team = s.nextInt();
            String[] time = s.next().split(":");
            hour = Integer.parseInt(time[0]);
            min = Integer.parseInt(time[1]);
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

        System.out.println(String.format("%02d:%02d\n%02d:%02d", team1_min/60, team1_min%60, team2_min/60,  team2_min%60) );

    }
}