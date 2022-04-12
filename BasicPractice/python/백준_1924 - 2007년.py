x,y = input().split()
month = [31,28,31,30,31,30,31,31,30,31,30,31]
day = ['SUN', 'MON', 'TUE', 'WED', 'THU', 'FRI', 'SAT']
total_day = 0

for i in range(int(x) - 1):
    total_day += month[i]

total_day += int(y)

ans = 0;
ans = total_day % 7
print(day[ans])
