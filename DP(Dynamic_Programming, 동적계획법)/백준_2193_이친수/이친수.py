x = int(input())

arr = [0 for _ in range(91)]
arr[1] = 1
for i in range(2, x+1):
    arr[i] = arr[i-1] + arr[i-2]

print(arr[x])
