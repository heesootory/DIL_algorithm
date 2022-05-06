L, R = map(int, input().split(' '))
min_cnt = 10

for i in range(L, R+1):
    n = i
    cnt = 0
    while n>0:
        if n %10 ==8: cnt+=1
        n //=10
    if cnt < min_cnt: min_cnt = cnt
    if min_cnt ==0 : break
print(min_cnt)
