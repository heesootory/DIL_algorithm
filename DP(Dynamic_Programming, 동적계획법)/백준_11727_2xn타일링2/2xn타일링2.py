arr = [0 for _ in range(1001)]
arr[0] = 0;
arr[1] = 1;
arr[2] = 3;
n = int(input())
for i in range(3, n+1):
    arr[i] = arr[i-1] * 2
    if i % 2 == 0: arr[i] += 1
    else: arr[i]-=1
    arr[i] %=10007
print(arr[n])