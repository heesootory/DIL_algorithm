n = int(input())

while n > 0:
    n-=1
    arr = list(map(int, input().split()))
    ever = 0
    for i in range(1,arr[0]+1):
        ever+= arr[i]

    ever /= arr[0]
    cnt = 0
    for i in range(1,arr[0]+1):
        if arr[i] > ever : cnt+=1

    print("%.3f%%" % (cnt*100/arr[0]))

