n, p = map(int, input().split())
m = n
cnt = 0
arr = [0 for _ in range(1001)]

while(1):
    i = (n*m)%p
    if arr[i] > 2: break
    arr[i] += 1
    m = i
    if arr[i] == 2: cnt += 1

print(cnt)



