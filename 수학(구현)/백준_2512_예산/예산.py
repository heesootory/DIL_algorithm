n = int(input())
arr = list(map(int, input().split(' ')))
sum = 0
max = 0
for i in range(n):
    if arr[i] > max:
        max = arr[i]
    sum += arr[i]

arr.sort()
total = int(input())
evg = total // n

def check(arr, evg):
    for i in range(n):
        if arr[i] < evg: return False
    return True

if sum <= total: print(max)
elif check(arr, evg) : print(evg)
else:
    start = 0
    end = 0
    for i in range(n-1):
        norm1 = arr[i]
        norm2 = arr[i+1]
        sum1 = 0
        sum2 = 0
        for j in range(n):
            if arr[j] > norm1 : sum1 += norm1
            else: sum1 += arr[j]
            if arr[j] > norm2 : sum2 += norm2
            else: sum2 += arr[j]
        if sum1 <= total and total <= sum2:
            start = norm1
            end = norm2

    while end - start > 1:
        max_sum = 0
        mid = (start + end)//2
        for i in range(n):
            if arr[i] > mid : max_sum += mid
            else: max_sum += arr[i]
        if max_sum > total: end = mid
        else : start = mid
    print(start)




