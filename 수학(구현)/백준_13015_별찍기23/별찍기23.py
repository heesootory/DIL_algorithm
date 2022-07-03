n = int(input())
arr = [[' ' for _ in range(400)] for _ in range(200)]
idx = 0

def set(n, r, idx):
    row = 2*n-1
    col = 4*n-3

    for i in range(0, col - idx + 1): arr[r][i] = ' '

    if r == 0 or r == row - 1:
        for i in range(0,n): arr[r][i] = '*'
        for i in range(col - n, col): arr[r][i] = '*'
    else:
        arr[r][idx] = '*'
        arr[r][idx + n - 1] = '*'
        arr[r][col - idx - 1] = '*'
        arr[r][col - idx - n] = '*'

    for i in range(0, col - idx + 1): print(f'{arr[r][i]}', end='')

for i in range(0, 2*n-1):
    set(n, i, idx)
    if i < n-1: idx+=1
    else: idx-=1
    print()
