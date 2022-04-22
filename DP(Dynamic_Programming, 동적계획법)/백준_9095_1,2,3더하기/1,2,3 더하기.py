arr = [0 for _ in range(11)]
arr[1] = 1; arr[2] = 2;  arr[3] = 4
T = int(input())
for i in range(T):
    n = int(input())
    if arr[n] > 0: print(arr[n])
    else:
        for j in range(4, n+1):
            arr[j] = arr[j-1] +arr[j-2] +arr[j-3]
        print(arr[n])
