n = int(input())
past_hour = 0
past_min = 0
hour = 0
min = 0
team = 0
team1_score = 0
team2_score = 0
team1_min = 0
team2_min = 0

while n > 0:
    n-=1
    team, time = input().split(' ')
    team = int(team)
    hour, min = map(int, time.split(':'))
    win_time = (hour - past_hour) * 60 + (min - past_min)
    if team1_score > team2_score: team1_min += win_time
    elif team1_score < team2_score: team2_min += win_time
    past_hour = hour
    past_min = min

    if team == 1: team1_score+=1
    else: team2_score+=1

final_time = (48 - past_hour)*60 - past_min
if team1_score > team2_score: team1_min += final_time
elif team1_score < team2_score: team2_min += final_time

print("%02d:%02d\n%02d:%02d" % (team1_min//60, team1_min%60, team2_min//60, team2_min%60))



