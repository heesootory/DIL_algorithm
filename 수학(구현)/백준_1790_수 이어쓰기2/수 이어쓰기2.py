N, k = map(int, input().split(' '))

norm = 1
norm_cnt = 9
all_cnt = 0
while N > norm_cnt:
    N -= norm_cnt
    all_cnt += (norm * norm_cnt)
    norm+=1
    norm_cnt*=10

all_cnt += (N * norm)
norm = 1
norm_cnt = 9
cnt = 0

while k > cnt + (norm * norm_cnt):
    cnt += (norm * norm_cnt)
    norm+=1
    norm_cnt *=10

cal = k - (cnt + 1)
quotient = cal // norm
remainder = cal % norm
i = norm - remainder
num = pow(10, norm-1) + quotient

ans = 0
while True:
    i-=1
    if i < 0: break
    ans = num %10
    num /=10
if k > all_cnt: print("-1")
else: print(int(ans))