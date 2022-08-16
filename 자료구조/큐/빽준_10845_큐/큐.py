from sys import stdin

n = int(stdin.readline())
arr = [0 for _ in range(10001)]
f = 0
b = 0
while n > 0:
    n-=1
    str = list(stdin.readline().split())
    if str[0] == "push":
        arr[b] = int(str[1])
        b+=1
    elif str[0] == "pop":
        if f == b: print("-1")
        else:
            print(arr[f])
            arr[f] = 0
            f+=1
    elif str[0] == "size": print(b-f)
    elif str[0] == "empty":
        if f == b: print("1")
        else: print("0")
    elif str[0] == "front":
        if f == b: print("-1")
        else: print(arr[f])
    elif str[0] == "back":
        if f == b: print("-1")
        else: print(arr[b-1])
