m,d = map(int, input().split())
month = [31,28,31,30,31,30,31,31,30,31,30,31]
week = ['MON', 'TUE', 'WED', 'THU', 'FRI', 'SAT', 'SUN']

sum = 0

for i in range(m-1):
    sum += month[i]
sum += (d-1)
print(week[sum % 7])