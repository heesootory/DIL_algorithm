arr = [0 for _ in range(1001)]
check = [0 for _ in range(1001)]

def cycle(n):
    count = 0
    for i in range(1, n+1):
        if check[i] == 0:
            count+=1
            start = i
            end = arr[i]
            while start != end:
                check[end] = 1
                end = arr[end]
    return count

T = int(input())
input_arr = []
while 1:
    T-=1
    if T == -1: break
    n = int(input())
    input_arr = list(map(int, input().split()))
    for i in range(1,n+1):
        arr[i] = input_arr[i-1]
        check[i] = 0
    print(cycle(n))

