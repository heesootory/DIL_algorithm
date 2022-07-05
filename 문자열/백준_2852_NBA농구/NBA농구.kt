import java.util.*

fun main(args: Array<String>) {
    val s = Scanner(System.`in`)
    var n = s.nextInt()
    var past_hour = 0
    var past_min = 0
    var hour = 0
    var min = 0
    var team = 0
    var team1_score = 0
    var team2_score = 0
    var team1_min = 0
    var team2_min = 0

    while(n-- > 0){
        team = s.nextInt()
        var time = s.next().split(':')
        hour = time[0].toInt()
        min = time[1].toInt()
        var win_time = (hour - past_hour) * 60 + (min - past_min) //분으로 정리

        if (team1_score > team2_score) team1_min += win_time
        else if (team1_score < team2_score) team2_min += win_time
        past_hour = hour
        past_min = min

        if (team == 1) team1_score++
        else team2_score++
    }
    var final_time: Int = (48 - past_hour) * 60 - past_min
    if (team1_score > team2_score)team1_min += final_time
    else if (team1_score < team2_score)team2_min += final_time

    print("%02d:%02d\n%02d:%02d".format(team1_min / 60, team1_min%60, team2_min/60, team2_min%60))
}