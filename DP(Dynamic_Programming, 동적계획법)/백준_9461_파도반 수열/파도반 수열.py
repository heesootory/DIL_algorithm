arr = [0 for _ in range(101)]
arr[1] = 1; arr[2] = 1; arr[3] = 1; arr[4] = 2; arr[5] = 2;
T = int(input())
for i in range(T):
    n = int(input())
    if n < 6: print(arr[n])
    else:
        for j in range(6, n+1):
            arr[j] = arr[j-1] + arr[j-5]
        print(arr[n])