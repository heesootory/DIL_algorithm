n = int(input())
m = int(input())

arr = [[0 for _ in range(1000)] for _ in range(1000)]
i = n//2
j = n//2
k = 1
num = 1

arr[i][j] = num

while k <= n:
    if k == n:
        for r in range(0, k-1):
            i-=1
            num+=1
            arr[i][j] = num
    elif k % 2 != 0:
        for r in range(0, k):
            i -=1
            num += 1
            arr[i][j] = num
        for r in range(0, k):
            j += 1
            num += 1
            arr[i][j] = num
    else:
        for r in range(0, k):
            i += 1
            num += 1
            arr[i][j] = num
        for r in range(0, k):
            j -= 1
            num += 1
            arr[i][j] = num
    k+=1

ans_i = 0
ans_j = 0
for a in range(0, n):
    for b in range(0, n):
        print(f'{arr[a][b]} ', end='')
        if arr[a][b] == m:
            ans_i = a
            ans_j = b
    print()
print(f'{ans_i+1} {ans_j+1}')

