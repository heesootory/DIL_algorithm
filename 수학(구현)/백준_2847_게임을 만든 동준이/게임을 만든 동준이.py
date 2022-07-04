n = int(input())
arr = [0 for _ in range(n)]

for i in range(n):
    arr[i] = int(input())

sum = 0
for i in range(n-1, 0, -1):
    if arr[i-1] >= arr[i]:
        sum += (arr[i-1] - (arr[i] - 1))
        arr[i-1] = arr[i] - 1

print(sum)
