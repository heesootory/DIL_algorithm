
x = int(input())

arr = [0 for _ in range(0, x+1)]

for i in range(0, x+1):
    arr[i] = i
    j = 0
    while j*j <= i:
        arr[i] = arr[i] if arr[i] < arr[i-j*j ]+1 else arr[i-j*j] +1
        j += 1

print(arr[x])

