N = int(input())

first_x = 0
first_y = 0
past_x = 0
past_y = 0
sum1 = 0
sum2 = 0

for i in range(0, N):
    x,y = map(int, input().split(' '))
    if i == 0:
        first_x = x
        first_y = y

    sum1 += past_x * y
    sum2 += past_y * x
    past_x = x
    past_y = y
sum1 += past_x * first_y
sum2 += past_y * first_x

max_sum = max(sum1, sum2)
min_sum = min(sum1, sum2)
ans = (max_sum - min_sum) / 2.0
ans = round(ans*10)/10
print(f'{ans:.1f}')

